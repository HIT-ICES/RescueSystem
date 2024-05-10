package com.hitices.localenvstatuswarner.client;


import com.hitices.common.MResponse;
import com.hitices.localenvstatuswarner.bean.EnvStatusBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BasicWarningReport", url = "http://basic-warning-report:8080")
public interface BasicWarningReportClient {
    @RequestMapping(value = "/ReportWarning", method = RequestMethod.POST)
    MResponse notifyWarning(@RequestBody EnvStatusBean envStatusBean);
}
