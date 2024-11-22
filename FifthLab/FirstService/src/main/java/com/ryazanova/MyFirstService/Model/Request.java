package com.ryazanova.MyFirstService.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.ryazanova.MyFirstService.Exception.UnsupportedCodeException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    // Уникальный идентификатор запроса
    @NotBlank
    @Size(max=32)
    private String uid;

    // Уникальный идентификатор операции, связанной с запросом
    @NotBlank
    @Size(max=32)
    private String operationUid;

    // Имя системы, с которой связан запрос (например, система, обрабатывающая запрос)
    private Systems systemName;

    // Время системы на момент создания запроса в формате строки
    @NotBlank
    private String systemTime;

    // Источник запроса (например, приложение или сервис)
    private String source;

    // Должность сотрудника, связанная с запросом (например, DEV, HR и т.д.)
    private Positions positions;

    // Оклад сотрудника, который используется для расчета премий
    private Double salary;

    // Процент бонуса, который будет применяться к окладу для расчета премий
    private Double bonus;

    // Количество рабочих дней, отработанных сотрудником за период
    private Integer workDays;

    // Идентификатор коммуникации, должен быть в диапазоне от 1 до 100000
    @Min(1)
    @Max(100000)
    private int communicationId;

    // Идентификатор шаблона, используемого для обработки запроса (если применимо)
    private int templateId;

    // Код продукта, связанный с запросом (если применимо)
    private int productCode;

    // Код SMS-уведомления (если применимо)
    private int smsCode;

    // Проверка уникального идентификатора на допустимость; выбрасывает исключение при недопустимом uid
    public void checkUid() throws UnsupportedCodeException {
        if ("123".equals(uid)) {
            throw new UnsupportedCodeException("Unsupported uid: " + uid);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "uid = '" + uid + '\'' +
                " operationUid = '" + operationUid + '\'' +
                " systemName = '" + systemName + '\'' +
                " systemTime = '" + systemTime + '\'' +
                " source = '" + source + '\'' +
                " positions = '" + positions + '\'' +
                " salary = '" + salary + '\'' +
                " bonus = '" + bonus + '\'' +
                " workDays = '" + workDays + '\'' +
                " communicationId = '" + communicationId + '\'' +
                " templateId = '" + templateId + '\'' +
                " productCode = '" + productCode + '\'' +
                " smsCode = '" + smsCode + '\'' +
                "}";
    }
}