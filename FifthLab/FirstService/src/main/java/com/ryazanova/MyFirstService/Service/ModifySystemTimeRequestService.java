package com.ryazanova.MyFirstService.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ryazanova.MyFirstService.Model.Request;
import com.ryazanova.MyFirstService.Util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeRequestService")
public class ModifySystemTimeRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

    }
}
