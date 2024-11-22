package com.ryazanova.MyFirstService.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    // Уникальный идентификатор запроса, к которому относится этот ответ
    private String uid;

    // Уникальный идентификатор операции, связанной с запросом
    private String operationUid;

    // Время системы на момент формирования ответа
    private String systemTime;

    // Код результата операции
    private Codes code;

    // Годовая премия, рассчитанная для сотрудника
    private Double annualBonus;

    // Квартальная премия, рассчитанная для сотрудника
    private Double quarterlyBonus;

    // Код ошибки, если операция завершилась неудачно
    private ErrorCodes errorCode;

    // Сообщение об ошибке, если операция завершилась неудачно
    private ErrorMessages errorMessage;
}