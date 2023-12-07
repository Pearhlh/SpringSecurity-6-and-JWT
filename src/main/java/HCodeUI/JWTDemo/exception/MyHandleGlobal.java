package HCodeUI.JWTDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyHandleGlobal {
    @ExceptionHandler(InternalAuthenticationServiceException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage handleException(InternalAuthenticationServiceException e) {
        return ErrorMessage
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .time(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(IndexOutOfBoundsException e) {
        return ErrorMessage
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .time(LocalDateTime.now())
                .build();
    }
}
