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

    @NotBlank
    @Size(max=32)
    private String uid;

    @NotBlank
    @Size(max=32)
    private String operationUid;

    private Systems systemName;

    @NotBlank
    private String systemTime;

    private String source;

    @Min(1)
    @Max(100000)
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;

    public void checkUid() throws UnsupportedCodeException {
        if ("123".equals(uid)) {
            throw new UnsupportedCodeException("Unsupported uid: " + uid);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                "systemName='" + systemName + '\'' +
                "systemTime='" + systemTime + '\'' +
                "source'" + source + '\'' +
                "communicationId=" + communicationId +
                "templateId=" + templateId +
                "productCode=" + productCode +
                "smsCode" + smsCode +
                "}";
    }
}

