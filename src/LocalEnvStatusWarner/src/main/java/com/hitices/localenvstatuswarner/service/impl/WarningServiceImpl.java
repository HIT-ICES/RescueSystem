package com.hitices.localenvstatuswarner.service.impl;

import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.localenvstatuswarner.bean.EnvStatusBean;
import com.hitices.localenvstatuswarner.bean.EnvironmentBean;
import com.hitices.localenvstatuswarner.client.BasicEnvReportClient;
import com.hitices.localenvstatuswarner.client.BasicWarningReportClient;
import com.hitices.localenvstatuswarner.client.EnvStatusInferClient;
import com.hitices.localenvstatuswarner.entity.EnvStatus;
import com.hitices.localenvstatuswarner.service.WarningService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("WarningServiceImpl")
@Slf4j
public class WarningServiceImpl implements WarningService {
    @Autowired
    private EnvStatusInferClient envStatusInferClient;

    @Autowired
    private BasicEnvReportClient basicEnvReportClient;

    @Autowired
    private BasicWarningReportClient basicWarningReportClient;

    @Override
    public EnvStatus getStatus(Environment environment) {
        MResponse response = envStatusInferClient.statusInfer(environment);
        if (response.getCode() == 0){
            EnvStatusBean envStatusBean = response.getData(EnvStatusBean.class);
            log.info(envStatusBean.getStatus());
            return new EnvStatus(envStatusBean.getStatus(),environment.getTimestamp());
        }
        return null;
    }

    @Override
    public MResponse reportStatus(EnvStatus envStatus) {
        if (envStatus!=null){
            EnvStatusBean envStatusBean = new EnvStatusBean(envStatus.getStatus(),envStatus.getTime());
            basicEnvReportClient.reportEnvStatus(envStatusBean);
            return MResponse.successMResponse();
        }
        return null;
    }

    @Override
    public MResponse notifyWarning(EnvStatus envStatus) {
        if (!envStatus.getStatus().equals("Normal")){
            EnvStatusBean envStatusBean = new EnvStatusBean(envStatus.getStatus(),envStatus.getTime());
            return  basicWarningReportClient.notifyWarning(envStatusBean);
        }
        return null;
    }
}
