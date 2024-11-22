package com.ryazanova.MySecondService.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ryazanova.MySecondService.Model.Response;
import com.ryazanova.MySecondService.Util.DateTimeUtil;

import java.util.Date;

@Slf4j
@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        response.setSystemTime(DateTimeUtil.getCustomFormat()
                .format(new Date()));
        log.info("update response system time: {}", response);
        return response;
    }
}
