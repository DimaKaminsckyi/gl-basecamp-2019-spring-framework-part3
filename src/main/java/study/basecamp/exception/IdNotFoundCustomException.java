package study.basecamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundCustomException extends RuntimeException {

    public IdNotFoundCustomException(String message) {
        super(message);
    }
}
