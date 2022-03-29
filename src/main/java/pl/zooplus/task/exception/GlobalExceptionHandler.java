package pl.zooplus.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestClientException.class)
    public ErrorMessage handleRestClientException() {
        final String message = "Something bad has happened with NBP api";
        log.debug(message);
        return new ErrorMessage()
                .setMessage(message)
                .setTimestamp(new Date())
                .setStatusCode(HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException.class)
    public ErrorMessage handleNullPointerException() {
        final String message = "Null value has occurred";
        log.debug(message);
        return new ErrorMessage()
                .setMessage(message)
                .setTimestamp(new Date())
                .setStatusCode(HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ArithmeticException.class)
    public ErrorMessage handleArithmeticException() {
        final String message = "Something bad has happened with calculating value";
        log.debug(message);
        return new ErrorMessage()
                .setMessage(message)
                .setTimestamp(new Date())
                .setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
