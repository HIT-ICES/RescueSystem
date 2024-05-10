package com.hitices.localenvstatuswarner.client;

import com.hitices.common.MResponse;
import com.hitices.localenvstatuswarner.bean.EnvStatusBean;
import com.hitices.localenvstatuswarner.bean.EnvironmentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BasicEnvReport",url = "http://basic-env-report:8080")
public interface BasicEnvReportClient {
    @RequestMapping(value = "/cloud/reportEnvStatus", method = RequestMethod.POST)
    MResponse reportEnvStatus(@RequestBody EnvStatusBean statusBean);
}
