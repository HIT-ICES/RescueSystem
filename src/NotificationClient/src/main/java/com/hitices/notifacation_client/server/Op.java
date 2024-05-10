package com.hitices.notifacation_client.server;


import com.hitices.common.MResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "NotificationServiceServer/operation", url = "http://notification-server:8080/operation")
public interface Op {


    @RequestMapping(value = "/getAllClientInfo", method = RequestMethod.POST)
    public MResponse getAllClientInfo();
}
