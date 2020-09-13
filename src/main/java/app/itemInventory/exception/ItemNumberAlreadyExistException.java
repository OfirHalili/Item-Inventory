package app.itemInventory.exception;

import org.springframework.http.HttpStatus;

public class ItemNumberAlreadyExistException extends ItemRequestException {
    public ItemNumberAlreadyExistException(Integer itemNumber) {
        super(HttpStatus.CONFLICT, "Item Number " + itemNumber + " Already Exist");
    }
}
