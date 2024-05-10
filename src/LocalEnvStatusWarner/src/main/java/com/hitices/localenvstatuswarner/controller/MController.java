package com.hitices.localenvstatuswarner.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.localenvstatuswarner.bean.DataBean;
import com.hitices.localenvstatuswarner.bean.EnvironmentBean;
import com.hitices.localenvstatuswarner.entity.EnvStatus;
import com.hitices.localenvstatuswarner.service.impl.StatusServiceImpl;
import com.hitices.localenvstatuswarner.service.impl.WarningServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 状态信息需要
 */
@RestController
@RequestMapping("/status-warn")
public class MController {

    @Autowired
    @Qualifier("WarningServiceImpl")
    private WarningServiceImpl warningService;

    @Autowired
    @Qualifier("StatusServiceImpl")
    private StatusServiceImpl statusService;

    /**
     *接受环境信息，并推断出当前环境状态
     */
    @PostMapping(value = "/reportEnvData")
    @ApiOperation(httpMethod = "POST", value = "接受环境信息，并推断出当前环境状态")
    public MResponse reportEnvData(@RequestBody Environment environment){
        EnvStatus envStatus = warningService.getStatus(environment);
        if (envStatus!=null){
            statusService.save(envStatus);
            warningService.reportStatus(envStatus);
            warningService.notifyWarning(envStatus);
            MResponse mResponse = new MResponse();
            mResponse.setCode(0);
            mResponse.set("data", envStatus);
            return mResponse;
        }
        return MResponse.failedMResponse();
    }

    @PostMapping(value = "/getStatusByTime")
    @ApiOperation(value = "获取历史环境状态信息", httpMethod = "POST")
    public MResponse getStatusByTime(@RequestBody DataBean dataBean){
        MResponse response = new MResponse();
        response.set("data", statusService.findAllByTime(dataBean));
        return response;
    }

    @PostMapping(value = "/getWarningStatus")
    @ApiOperation(value = "获取历史环境警报状态信息", httpMethod = "POST")
    public MResponse getWarningStatus(@RequestBody DataBean dataBean){
        MResponse response = new MResponse();
        response.set("data", statusService.findWarningByTime(dataBean));
        return response;
    }
}
