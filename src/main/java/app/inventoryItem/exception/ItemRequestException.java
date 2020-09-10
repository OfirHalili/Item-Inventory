package app.inventoryItem.exception;

public class ItemRequestException extends RuntimeException{
    public ItemRequestException(String message){
        super(message);
    }
}
