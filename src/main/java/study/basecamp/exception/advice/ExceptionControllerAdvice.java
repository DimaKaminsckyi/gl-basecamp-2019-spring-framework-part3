package study.basecamp.exception.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import study.basecamp.exception.ErrorDetails;
import study.basecamp.exception.IdNotFoundCustomException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdNotFoundCustomException.class)
    public ResponseEntity<ErrorDetails> idNotFoundExceptionHandler(IdNotFoundCustomException ex , HttpServletResponse response){
        ErrorDetails exception = new ErrorDetails(404 , ex.getMessage());
        return new ResponseEntity<>(exception , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> handleValidateException(ConstraintViolationException ex){
        ErrorDetails details = new ErrorDetails(400 , ex.getMessage());
        return new ResponseEntity<>( details , HttpStatus.BAD_REQUEST);
    }

}
