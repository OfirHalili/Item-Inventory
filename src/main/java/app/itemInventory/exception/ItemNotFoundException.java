package app.itemInventory.exception;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends ItemRequestException {
    public ItemNotFoundException(int itemNumber) {
        super(HttpStatus.NOT_FOUND, "Item Number " + itemNumber + " Not Found");

    }


}
