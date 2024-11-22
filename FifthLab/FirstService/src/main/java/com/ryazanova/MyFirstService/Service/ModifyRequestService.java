package com.ryazanova.MyFirstService.Service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ryazanova.MyFirstService.Model.Request;

@Service
@Qualifier("ModifySourceRequestService")
public interface ModifyRequestService {

    void modify(Request request);

}
