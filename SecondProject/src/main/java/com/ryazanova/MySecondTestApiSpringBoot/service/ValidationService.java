package com.ryazanova.MySecondTestApiSpringBoot.service;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.ryazanova.MySecondTestApiSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
