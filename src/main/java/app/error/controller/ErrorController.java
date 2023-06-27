package app.error.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import app.error.exception.PathIdNotFoundException;
import app.error.to.ErrorResultTO;
import app.error.to.ErrorTO;

@RestControllerAdvice
public class ErrorController {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResultTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ErrorTO> errors = e.getBindingResult()
                                        .getFieldErrors()
                                        .stream()
                                        .map(fieldError -> new ErrorTO(fieldError.getField(), fieldError.getDefaultMessage()))
                                        .collect(Collectors.toList());
        ErrorResultTO to = new ErrorResultTO();
        to.setErrors(errors);
        return to;
    }

    @ExceptionHandler(PathIdNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResultTO handlePathIdNotFoundException(PathIdNotFoundException e){
        ErrorTO error = new ErrorTO(e.getErrorPathName(), "path value["+e.getErrorPathValue()+"] is not found");
        List<ErrorTO> errors = new ArrayList<>();
        errors.add(error);
        
        ErrorResultTO to = new ErrorResultTO();
        to.setErrors(errors);
        return to;
    }
}
