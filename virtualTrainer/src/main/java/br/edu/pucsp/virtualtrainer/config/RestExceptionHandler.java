package br.edu.pucsp.virtualtrainer.config;

import br.edu.pucsp.virtualtrainer.exception.DataNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@ControllerAdvice
@Order
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * Catch all for any other exceptions...
     */
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ResponseEntity<Object> handleAnyException(Exception e, HttpServletRequest request) {
        logException(e, request);
        return formatResponse("Error processing request", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle failures commonly thrown from code
     */
    @ExceptionHandler({ InvocationTargetException.class, IllegalArgumentException.class, ClassCastException.class,
            ConversionFailedException.class })
    @ResponseBody
    public ResponseEntity<Object> handleMiscFailures(Exception e, HttpServletRequest request) {
        logException(e, request);
        return formatResponse("Unexpected error", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFound(DataNotFoundException e, HttpServletRequest req){
        logException(e, req);

        return formatResponse("Data not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest req){
        logException(e, req);
        String message = "Database error";
        String cause = e.getMessage();
        if (e.getCause() instanceof ConstraintViolationException){
            cause = "Constraint violated";
            message = ((ConstraintViolationException) e.getCause()).getConstraintName();
        }
        return formatResponse(String.join(":", cause, message), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logException(null, (((ServletWebRequest) request).getRequest()));

        Map<Object, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));

        log.error("Error validating request {}", errors);
        return formatResponse(errors, HttpStatus.BAD_REQUEST);
    }

    private void logException(Exception e, HttpServletRequest req) {
        log.error("Request URI: {} - {}", req.getMethod(), req.getRequestURI());
        if(nonNull(e)){
            log.error("Exception message: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    private <T> ResponseEntity<Object> formatResponse(T message, HttpStatus status){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("message", message);
        return new ResponseEntity<>(body, status);
    }

}
