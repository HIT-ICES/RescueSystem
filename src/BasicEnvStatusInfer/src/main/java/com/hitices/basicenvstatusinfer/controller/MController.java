package com.hitices.basicenvstatusinfer.controller;

import com.hitices.basicenvstatusinfer.ann.AnnClassifier;
import com.hitices.basicenvstatusinfer.bean.EnvStatusBean;
import com.hitices.basicenvstatusinfer.bean.EnvironmentBean;
import com.hitices.basicenvstatusinfer.util.DataUtil;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statusInfer")
public class MController {

    @PostMapping("/getStatus")
    @ApiOperation(value = "根据环境信信息推断当前环境状态", httpMethod = "POST")
    public MResponse statusInfer(@RequestBody Environment environment){
        MResponse response = MResponse.successMResponse();
        DataUtil dataUtil = DataUtil.getInstance();
        int type = AnnClassifier.getInstance().test(dataUtil.getEnvData(environment));
        response.set("data", new EnvStatusBean(dataUtil.getTypeName(type),environment.getTimestamp()));
        response.setCode(0);
        return response;
    }


}
