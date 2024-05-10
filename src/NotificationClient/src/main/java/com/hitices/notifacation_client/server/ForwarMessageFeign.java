package com.hitices.notifacation_client.server;

import com.hitices.common.MResponse;
import com.hitices.notifacation_client.bean.Notice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/09/24
 */
@Component
@FeignClient(name = "NotificationServiceServer/forward", url = "http://notification-server:8080/forward")
public interface ForwarMessageFeign {


    @RequestMapping(value = "/forwardOne", method = RequestMethod.POST)
    public MResponse forwardOne(@RequestBody Notice notice);


    @RequestMapping(value = "/radioToClient", method = RequestMethod.POST)
    public MResponse radioToClient(@RequestBody Notice notice);


    @RequestMapping(value = "/radioToServer", method = RequestMethod.POST)
    public MResponse radioToServer(@RequestBody Notice notice);



}
