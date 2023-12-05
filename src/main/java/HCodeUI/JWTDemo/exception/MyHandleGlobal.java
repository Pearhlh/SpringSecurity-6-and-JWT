package HCodeUI.JWTDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyHandleGlobal {
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          ErrorMessage
                  .builder()
                  .message(e.getMessage())
                  .status(HttpStatus.BAD_REQUEST.value())
                  .time(LocalDateTime.now())
                  .build()
        );
    }
}
