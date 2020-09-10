package app.inventoryItem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler(value = {ItemNotFoundException.class, ItemNumberAlreadyExistException.class})
    public ResponseEntity<Object> handelItemRequestException(ItemRequestException exception){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ItemException itemException = new ItemException(exception.getMessage(), badRequest, ZonedDateTime.now());
        return new ResponseEntity<>(itemException, badRequest);
    }
}
