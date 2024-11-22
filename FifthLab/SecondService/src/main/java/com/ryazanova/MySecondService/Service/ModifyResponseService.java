package com.ryazanova.MySecondService.Service;

import org.springframework.stereotype.Service;
import com.ryazanova.MySecondService.Model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
