package com.ryazanova.MyFirstService.Controller;

import com.ryazanova.MyFirstService.Model.*;
import com.ryazanova.MyFirstService.Service.AnnualBonusService;
import com.ryazanova.MyFirstService.Service.ModifyRequestService;
import com.ryazanova.MyFirstService.Service.ModifyResponseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ryazanova.MyFirstService.Exception.ValidationFailedException;
import com.ryazanova.MyFirstService.Exception.UnsupportedCodeException;
import com.ryazanova.MyFirstService.Service.ValidationService;
import com.ryazanova.MyFirstService.Util.DateTimeUtil;

import java.util.Date;

import com.ryazanova.MyFirstService.Service.QuarterlyBonusService;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final AnnualBonusService annualBonusService;
    private final QuarterlyBonusService quarterlyBonusService; // New service

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifyFeaturesRequestService") ModifyRequestService modifyRequestService,
                        AnnualBonusService annualBonusService,
                        QuarterlyBonusService quarterlyBonusService) { // Injecting new service
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.annualBonusService = annualBonusService;
        this.quarterlyBonusService = quarterlyBonusService; // Initializing new service
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("Запрос: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("Запрос создан: {}", response);

        try {
            request.checkUid();
            validationService.isValid(bindingResult);

            // Calculate annual bonus if applicable
            if (request.getPositions() != null) {
                double annualBonus = annualBonusService.calculate(request.getPositions(),
                        request.getSalary(),
                        request.getBonus(),
                        request.getWorkDays());
                response.setAnnualBonus(annualBonus);

                // Calculate quarterly bonus only for MAN position
                double quarterlyBonus = quarterlyBonusService.calculate(request.getPositions(),
                        request.getSalary(),
                        request.getBonus(),
                        request.getWorkDays());

                // Set quarterly bonus in response; it will be 0 if position is not MAN
                response.setQuarterlyBonus(quarterlyBonus);
            }

        } catch (UnsupportedCodeException e) {
            log.error("Непредвиденная ошибка кода {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e) {
            log.error("Ошибка валидации {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Не поддерживаемая ошибка {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("Ответ: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Response modifiedResponse = modifyResponseService.modify(response);
        modifyRequestService.modify(request);

        return ResponseEntity.ok(modifiedResponse);
    }
}