package com.ryazanova.MyFirstService.Service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import com.ryazanova.MyFirstService.Model.Request;
import com.ryazanova.MyFirstService.Model.Systems;
import org.springframework.web.client.RestTemplate;

@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.FIRST_SERVICE);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange(
                "http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>(){}
        );
    }
}
