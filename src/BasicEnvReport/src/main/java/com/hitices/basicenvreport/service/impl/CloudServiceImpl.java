package com.hitices.basicenvreport.service.impl;

import com.hitices.basicenvreport.bean.EnvDataWithPositionBean;
import com.hitices.basicenvreport.bean.EnvStatusBean;
import com.hitices.basicenvreport.bean.EnvStatusWithPositionBean;
import com.hitices.basicenvreport.config.LocalConfig;
import com.hitices.basicenvreport.service.CloudService;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CloudServiceImpl implements CloudService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LocalConfig localConfig;

    @Override
    public MResponse reportEnvData(Environment environment) {
        EnvDataWithPositionBean envDataWithPositionBean = new EnvDataWithPositionBean();
        envDataWithPositionBean.setPosition(localConfig.getPosition());
        envDataWithPositionBean.setEnvironment(environment);
        HttpEntity requestEntity = new HttpEntity(envDataWithPositionBean,null);
        ResponseEntity<MResponse> re =  restTemplate.exchange(
                "http://"+localConfig.getCloudUrl()+"/cloud/insertEnv",
                HttpMethod.POST,
                requestEntity,
                MResponse.class
        );
        return re.getBody();
    }

    @Override
    public MResponse reportEnvStatus(EnvStatusBean status) {
        HttpEntity requestEntity = new HttpEntity(
                new EnvStatusWithPositionBean(status.getStatus(), localConfig.getPosition(), status.getTime()),
                null);
        ResponseEntity<MResponse> re =  restTemplate.exchange(
                "http://"+localConfig.getCloudUrl()+"/cloud/insertStatus",
                HttpMethod.POST,
                requestEntity,
                MResponse.class
        );
        return re.getBody();
    }
}
