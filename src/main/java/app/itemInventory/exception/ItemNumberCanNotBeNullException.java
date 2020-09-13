package app.itemInventory.exception;

import org.springframework.http.HttpStatus;

public class ItemNumberCanNotBeNullException extends ItemRequestException {
    public ItemNumberCanNotBeNullException() {
        super(HttpStatus.BAD_REQUEST, " Item Number Can Not Be Null");
    }
}
