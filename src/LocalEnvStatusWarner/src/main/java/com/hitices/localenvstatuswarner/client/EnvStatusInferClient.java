package com.hitices.localenvstatuswarner.client;


import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.localenvstatuswarner.bean.EnvironmentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BasicEnvStatusInfer", url = "http://basic-env-status-infer:8080")
public interface EnvStatusInferClient {
    @RequestMapping(value = "/statusInfer/getStatus",method = RequestMethod.POST)
    MResponse statusInfer(@RequestBody Environment environment);

}
