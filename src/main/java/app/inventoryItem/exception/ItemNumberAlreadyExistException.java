package app.inventoryItem.exception;

public class ItemNumberAlreadyExistException extends ItemRequestException{
    public ItemNumberAlreadyExistException(){
        super("Item Number Already Exist");
    }
}
