package com.healthedge.sso.common.exception.handler;

import com.healthedge.sso.common.dto.Response;
import com.healthedge.sso.common.exception.BusinessException;
import com.healthedge.sso.common.exception.ExceptionResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerRequetExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ControllerRequetExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity unhandledException(Exception ex) {
        LOGGER.error(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(ex));
        String message = "Something went wrong";
        Response response = new Response("error", message);
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity businessExceptionHandler(BusinessException ex) {
        String statuscode = ex.getErrorCode();
        String message = ex.getMessage();
        Response response = new Response(statuscode, message);
        return new ResponseEntity(response, ex.getHttpStatus() == null ? HttpStatus.BAD_REQUEST : ex.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception) {
        String statuscode = "";
        String message = "Invalid Request";
        try {
            statuscode = exception.getBindingResult().getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(exception.getMessage());
            message = ExceptionResourceBundle.getInstance().getErrorMessage(statuscode);
        } catch (Exception e) {
            message = "Invalid Request.";
        }

        Response response = new Response(statuscode, message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }
}
