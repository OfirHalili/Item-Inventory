package app.itemInventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ItemRequestException extends HttpClientErrorException {

    public ItemRequestException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
