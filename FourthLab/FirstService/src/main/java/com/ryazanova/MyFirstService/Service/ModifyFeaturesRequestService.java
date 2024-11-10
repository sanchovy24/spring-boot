package com.ryazanova.MyFirstService.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ryazanova.MyFirstService.Model.Request;

@Service
@Qualifier("ModifyFeaturesRequestService")
public class ModifyFeaturesRequestService implements ModifyRequestService{

    private final ModifyRequestService systemNameService;
    private final ModifyRequestService sourceService;
    private final ModifyRequestService systemTimeService;

    public ModifyFeaturesRequestService(
            @Qualifier("ModifySystemNameRequestService") ModifyRequestService systemNameService,
            @Qualifier("ModifySourceRequestService") ModifyRequestService sourceService,
            @Qualifier("ModifySystemTimeRequestService") ModifyRequestService systemTimeService
    ) {
        this.systemNameService = systemNameService;
        this.sourceService = sourceService;
        this.systemTimeService = systemTimeService;
    }

    @Override
    public void modify(Request request) {
        systemNameService.modify(request);
        sourceService.modify(request);
        systemTimeService.modify(request);

    }
}
