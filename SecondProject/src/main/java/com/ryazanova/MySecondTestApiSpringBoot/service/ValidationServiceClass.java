package com.ryazanova.MySecondTestApiSpringBoot.service;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.ryazanova.MySecondTestApiSpringBoot.exception.ValidationFailedException;

@Service
public class ValidationServiceClass implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
