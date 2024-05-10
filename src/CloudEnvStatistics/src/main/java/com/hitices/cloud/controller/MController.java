package com.hitices.cloud.controller;


import com.hitices.cloud.bean.EnvDataWithPositionBean;
import com.hitices.cloud.bean.EnvInfoFilterBean;
import com.hitices.cloud.bean.EnvStatusWithPositionBean;
import com.hitices.cloud.entity.EnvInfoEntity;
import com.hitices.cloud.repository.EnvRepository;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MController {

    @Autowired
    EnvRepository envRepository;

    @PostMapping(value = "/cloud/insertEnv")
    @ApiOperation("收集环境数据")
    public MResponse reportEnvData(@RequestBody EnvDataWithPositionBean environment){
        System.out.println(environment.getTimestamp().toString());
        EnvInfoEntity envInfoEntity = envRepository.findByTimeAndPosition(environment.getTimestamp(),environment.getPosition());
        if (envInfoEntity == null){
            envInfoEntity = new EnvInfoEntity();
            envInfoEntity.setPosition(environment.getPosition());
            envInfoEntity.setTime(environment.getTimestamp());
        }
        envInfoEntity.setData(environment.toString());
        envRepository.save(envInfoEntity);
        return MResponse.successMResponse();
    }

    @PostMapping(value = "/cloud/insertStatus")
    @ApiOperation("收集环境状态")
    public MResponse reportEnvStatus(@RequestBody EnvStatusWithPositionBean status){
        EnvInfoEntity envInfoEntity = envRepository.findByTimeAndPosition(status.getTime(),status.getPosition());
        if (envInfoEntity == null){
            envInfoEntity = new EnvInfoEntity();
            envInfoEntity.setPosition(status.getPosition());
            envInfoEntity.setTime(status.getTime());
        }
        envInfoEntity.setStatus(status.getStatus());
        envInfoEntity.setTime(new Date());
        envInfoEntity.setPosition(status.getPosition());
        envRepository.save(envInfoEntity);
        return MResponse.successMResponse();
    }

    @PostMapping(value = "/cloud/getEnvInfo")
    @ApiOperation("获取环境信息")
    public MResponse getEnvInfo(@RequestBody EnvInfoFilterBean envInfoFilterBean){
        MResponse response = MResponse.successMResponse();
        List<EnvInfoEntity> envInfoEntities =  envRepository.findByPositionAndTimeBetween(envInfoFilterBean.getPosition(),envInfoFilterBean.getStart(),envInfoFilterBean.getEnd());
        response.set("data", envInfoEntities);
        return response;
    }
}
