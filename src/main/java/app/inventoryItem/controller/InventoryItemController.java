package app.inventoryItem.controller;

import app.inventoryItem.service.InventoryItemService;
import app.inventoryItem.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-inventory")
public class InventoryItemController {
    @Autowired
    private InventoryItemService inventoryItemService;

    @GetMapping("/")
    public List<Item> getAllItems(){
        return inventoryItemService.getAllItems();
    }
    @GetMapping("/{itemNumber}")
    public Item getItem(@PathVariable int itemNumber){
        return inventoryItemService.getItem(itemNumber);
    }
    @PostMapping
    public void addItem(@RequestBody Item item){
        inventoryItemService.addItem(item);
    }
    @GetMapping("/{itemNumber}/amount")
    public int withdrawalQuantityByItemNumber(@PathVariable int itemNumber){
        return inventoryItemService.withdrawalQuantityByItemNumber(itemNumber);
    }
    @PutMapping("/{itemNumber}/amount/{amount}")
    public void depositQuantityByItemId( @PathVariable  int itemNumber,@PathVariable  int amount ){
        inventoryItemService.depositQuantityByItemId(itemNumber, amount);
    }
    @DeleteMapping("/{itemNumber}")
    public void deleteItem(@PathVariable int itemNumber){
        inventoryItemService.deleteItem(itemNumber);
    }
}
