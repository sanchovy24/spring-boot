package com.ryazanova.MyApplicationH2.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationResult<T> {

    public static final String SUCCESS_MESSAGE = "Операция выполнена успешно";
    public static final String ERROR_MESSAGE = "Операция завершена с ошибкой";

    private String message;
    private T result;
}
