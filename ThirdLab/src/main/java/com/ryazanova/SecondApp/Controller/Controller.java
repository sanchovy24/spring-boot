package com.ryazanova.SecondApp.Controller;

import com.ryazanova.SecondApp.Exception.ValidationFailedException;
import com.ryazanova.SecondApp.Model.*;
import com.ryazanova.SecondApp.Service.ModifyResponseService;
import com.ryazanova.SecondApp.Service.ValidationService;
import com.ryazanova.SecondApp.util.DateTimeUtil;
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
import com.ryazanova.SecondApp.Exception.UnsupportedCodeException;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class Controller {
    private final ValidationService validationService;
    private ModifyResponseService modifyResponseService;
    @Autowired
    public Controller(ValidationService validationService, @Qualifier("modifySystemTimeResponseService") ModifyResponseService modifyResponseService)  {

        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("запрос: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("запрос создан: {}", request);
        try {
            request.checkUid();
            validationService.isValid(bindingResult);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("произошла неизвестная ошибка: {}", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("произошла ошибка валидации: {}", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("произошла ошибка: {}", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(response);
        log.info("ответ: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

