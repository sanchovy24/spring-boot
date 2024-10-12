package com.ryazanova.SecondApp.Service;

import com.ryazanova.SecondApp.Exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class RequestValidationService implements ValidationService{
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if (bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
