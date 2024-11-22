package com.ryazanova.MySecondService.Exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UnsupportedCodeException extends Exception {

    public UnsupportedCodeException(@NotBlank @Size(max = 32) String s) {}
    }

