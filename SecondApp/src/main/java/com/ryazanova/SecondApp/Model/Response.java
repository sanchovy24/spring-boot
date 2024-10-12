package com.ryazanova.SecondApp.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Response {
    private String uid;
    private String operationUid;
    private String systemName;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;

}
