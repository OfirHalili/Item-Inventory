package app.itemInventory.service;

import app.itemInventory.exception.ItemNumberAlreadyExistException;
import app.itemInventory.exception.ItemNotFoundException;
import app.itemInventory.repository.ItemRepository;
import app.itemInventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemInventoryService {
    @Autowired
    private ItemRepository itemRepository;

    // get all items from the inventory
    public List<Item> getAllItems() {
        List<Item> itemsList = new ArrayList<>();
        itemRepository.findAll().forEach(itemsList::add);
        return itemsList;
    }

    // get item details according to item number
    public Item getItem(int itemNumber) {
        Optional<Item> byId = itemRepository.findById(itemNumber);
        if (!byId.isPresent()) {
            throw new ItemNotFoundException(itemNumber);
        }
        return byId.get();
    }

    // add item to inventory only if the item number doesn't exist already
    public void addItem(Item item) {

        Integer itemNumber = item.getItemNumber();
        if (!itemRepository.existsById(itemNumber)) {
            itemRepository.save(item);
        } else {
            throw new ItemNumberAlreadyExistException(itemNumber);
        }
    }

    // get the quantity of a specific item in inventory according to item number
    public int withdrawalQuantityByItemNumber(int itemNumber) {
        return getItem(itemNumber).getAmount();
    }

    public void depositQuantityByItemId(int itemNumber, int amount) {
        Item item = getItem(itemNumber);
        item.setAmount(amount);
        itemRepository.save(item);

    }

    // delete specific item according to item number
    public void deleteItem(int itemNumber) {
        itemRepository.delete(getItem(itemNumber));
    }
}
