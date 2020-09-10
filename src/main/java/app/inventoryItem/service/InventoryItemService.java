package app.inventoryItem.service;

import app.inventoryItem.exception.ItemNumberAlreadyExistException;
import app.inventoryItem.exception.ItemNotFoundException;
import app.inventoryItem.repository.ItemRepository;
import app.inventoryItem.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        List<Item> itemsList = new ArrayList<>();
         itemRepository.findAll().forEach(itemsList :: add);
        return itemsList;
    }

    public Item getItem(int itemNumber) {
        if(!itemRepository.existsById(itemNumber)){
            throw new ItemNotFoundException();
        }
        return itemRepository.findById(itemNumber).get();
    }
    public void addItem(Item item) {

        if(!itemRepository.existsById(item.getItemNumber())){
            itemRepository.save(item);
        }else {
            throw new ItemNumberAlreadyExistException();
        }
    }

    public int withdrawalQuantityByItemNumber(int itemNumber) {
       return getItem(itemNumber).getAmount();
    }
    public void depositQuantityByItemId(int itemNumber, int amount){
        Item item = getItem(itemNumber);
        item.setAmount(amount);
        itemRepository.save(item);

    }
    public void deleteItem(int itemNumber) {
        itemRepository.delete(getItem(itemNumber));
    }
}
