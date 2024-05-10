package com.hitices.basicenvreport.controller;

import com.hitices.basicenvreport.bean.EnvStatusBean;
import com.hitices.basicenvreport.config.LocalConfig;
import com.hitices.basicenvreport.service.CloudService;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cloud")
public class CloudController {
    @Autowired
    private LocalConfig localConfig;

    @Autowired
    private CloudService cloudService;

    @PostMapping(value = "/reportEnvData")
    @ApiOperation("向云端上报环境信息")
    public MResponse reportEnvData(@RequestBody Environment environment){
        return this.cloudService.reportEnvData(environment);
    }

    @PostMapping(value = "/reportEnvStatus")
    @ApiOperation("向云端上报环境状态")
    public MResponse reportEnvStatus(@RequestBody EnvStatusBean status){
        return this.cloudService.reportEnvStatus(status);
    }
}
