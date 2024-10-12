package com.ryazanova.MySecondTestApiSpringBoot.exception;

public class ValidationFailedException extends Throwable {
    public ValidationFailedException(String message) { super(message);}
}
