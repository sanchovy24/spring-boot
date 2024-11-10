package com.ryazanova.MySecondService.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ryazanova.MySecondService.Model.Response;

import java.util.UUID;

@Slf4j
@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {

        UUID uid = UUID.randomUUID();

        response.setOperationUid(uid.toString());

        log.info("обновлен uid: {}", response);
        return response;
    }
}
