package cats.borzik.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BorzikGlobalExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<BorzikErrorData> handleException(BorzikException exception) {
        BorzikErrorData errorData = new BorzikErrorData();
        errorData.setInfo(exception.getMessage());
        return new ResponseEntity<>(errorData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<BorzikErrorData> handleException(Exception exception) {
        BorzikErrorData errorData = new BorzikErrorData();
        errorData.setInfo(exception.getMessage());
        return new ResponseEntity<>(errorData, HttpStatus.BAD_REQUEST);
    }

    @Data
    public static class BorzikErrorData {
        private String info;
    }

    public static class BorzikException extends RuntimeException {
        public BorzikException(String message) {
            super(message);
        }
    }
}
