package com.ryazanova.MySecondService.Service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.ryazanova.MySecondService.Exception.ValidationFailedException;

@Service
public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
