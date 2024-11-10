package com.ryazanova.MyFirstService.Service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.ryazanova.MyFirstService.Exception.ValidationFailedException;

@Service
public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
