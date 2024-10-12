package com.ryazanova.MySecondTestApiSpringBoot.model;

import ch.qos.logback.core.spi.ErrorCodes;
import lombok.Builder;
import lombok.Data;

import java.security.CodeSigner;
import java.util.logging.ErrorManager;

@Data
@Builder
public class Response {

    private String uid;
    private String operationUid;
    private System systemName;
    private String systemTime;
    private Code code;
    private ErrorCodes errorCode;
    private ErrorManager errorMessage;
}

