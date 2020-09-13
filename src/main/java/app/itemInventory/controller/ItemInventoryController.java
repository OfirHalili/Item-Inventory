package app.itemInventory.controller;

import app.itemInventory.exception.ItemNumberCanNotBeNullException;
import app.itemInventory.service.ItemInventoryService;
import app.itemInventory.model.Item;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-inventory")
public class ItemInventoryController {
    @Autowired
    private ItemInventoryService itemInventoryService;

    @GetMapping("/")
    @ApiOperation(value = "Find all items", notes = "Get all items in inventory", response = List.class)
    public List<Item> getAllItems() {
        return itemInventoryService.getAllItems();
    }

    @GetMapping("/{itemNumber}")
    @ApiOperation(value = "Find item", notes = "Provide an item number for a search of a specific item from inventory ", response = Item.class)
    public Item getItem(@PathVariable int itemNumber) {
        return itemInventoryService.getItem(itemNumber);
    }

    @PostMapping
    @ApiOperation(value = "Add item to inventory", notes = "Provide an item to add to inventory ")
    public void addItem(@RequestBody Item item) {
        if (item.getItemNumber() == null) {
            throw new ItemNumberCanNotBeNullException();
        }
        itemInventoryService.addItem(item);
    }

    @GetMapping("/{itemNumber}/amount")
    @ApiOperation(value = "Get the quantity of a specific item" , notes = "Provide an item number to receive its quantity", response = Integer.class)
    public int withdrawalQuantityByItemNumber(@PathVariable int itemNumber) {
        return itemInventoryService.withdrawalQuantityByItemNumber(itemNumber);
    }

    @PutMapping("/{itemNumber}/amount/{amount}")
    @ApiOperation(value = "deposit quantity" , notes = "Provide an item number and quantity to update the item quantity")
    public void depositQuantityByItemId(@PathVariable int itemNumber, @PathVariable int amount) {
        itemInventoryService.depositQuantityByItemId(itemNumber, amount);
    }

    @DeleteMapping("/{itemNumber}")
    @ApiOperation(value = "Delete item" , notes = "Provide an item number in order to delete the item from inventory")
    public void deleteItem(@PathVariable int itemNumber) {
        itemInventoryService.deleteItem(itemNumber);
    }
}
