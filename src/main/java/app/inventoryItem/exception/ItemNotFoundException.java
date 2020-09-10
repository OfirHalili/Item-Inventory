package app.inventoryItem.exception;

public class ItemNotFoundException extends ItemRequestException{
    public ItemNotFoundException(){
        super("Item Not Found");
    }


}
