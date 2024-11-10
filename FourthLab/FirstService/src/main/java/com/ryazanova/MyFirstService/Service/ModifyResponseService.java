package com.ryazanova.MyFirstService.Service;

import org.springframework.stereotype.Service;
import com.ryazanova.MyFirstService.Model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
