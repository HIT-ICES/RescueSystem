package com.hitices.basicenvreport.controller;

import com.hitices.basicenvreport.client.BasicEnvironmentStatisticsClient;
import com.hitices.common.MResponse;
import com.hitices.basicenvreport.bean.BatchInsertBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class EnvDataController {
    @Autowired
    private BasicEnvironmentStatisticsClient basicEnvironmentStatisticsClient;

    @PostMapping(value = "/reportEnvironment")
    @ApiOperation("向异构环境数据收集服务上报结构化人工数据")
    public MResponse reportEnvironment(@RequestBody BatchInsertBean batchInsertBean){
        return this.basicEnvironmentStatisticsClient.insert(batchInsertBean);
    }
}
