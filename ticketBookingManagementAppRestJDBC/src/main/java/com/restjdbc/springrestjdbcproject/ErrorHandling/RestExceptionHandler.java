package com.restjdbc.springrestjdbcproject.ErrorHandling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException mnve,HttpServletRequest request){

    //setting Error Details
    ErrorDetails errorDetails=new ErrorDetails();
    errorDetails.setTimeStamp(new Date().getTime());
    errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
    String requestPath=(String) request.getAttribute("javax.servlet.error.request_uri");
    if (requestPath == null) {
      requestPath=request.getRequestURI();
    }
    errorDetails.setTitle("validation Failed");
    errorDetails.setDetail("Input Validation Failed");
    errorDetails.setDeveloperMessage(mnve.getClass().getName());

    //Validation error instances
    List<FieldError> fieldErrors=mnve.getBindingResult().getFieldErrors();
    for (FieldError fe:fieldErrors){

      List<ValidatonError> validatonErrorList=errorDetails.getErrors().get(fe.getField());
      if (validatonErrorList == null) {
        validatonErrorList=new ArrayList<>();
        errorDetails.getErrors().put(fe.getField(),validatonErrorList);
      }
      ValidatonError validatonError=new ValidatonError();
      validatonError.setCode(fe.getCode());
      validatonError.setMessage(fe.getDefaultMessage());
      validatonErrorList.add(validatonError);

    }
    return new ResponseEntity<>(errorDetails,null,HttpStatus.BAD_REQUEST);
  }

}
