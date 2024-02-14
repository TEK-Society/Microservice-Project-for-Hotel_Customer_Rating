package Ratiing.Exception;

import Ratiing.Dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)

    public ResponseEntity<ErrorDetails> handleExceptionError (Exception exception , WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), new Date() , webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
