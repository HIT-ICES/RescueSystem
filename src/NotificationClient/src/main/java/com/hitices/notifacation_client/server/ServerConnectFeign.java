package com.hitices.notifacation_client.server;

import com.hitices.common.MResponse;
import com.hitices.notifacation_client.bean.Notice;
import com.hitices.notifacation_client.bean.ClientInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 * 用来与 通知服务服务端进行链接
 */
@Component
@FeignClient(name = "NotificationServiceServer/server", url = "http://notification-server:8080/server")
public interface ServerConnectFeign {

    /**
     * 接受信息
     * @param notice 接受的信息通知
     * @return
     */
    @RequestMapping(value = "/recieveMessage", method = RequestMethod.POST)
    public MResponse sendMessage(@RequestBody Notice notice);


    /**
     *
     * @param clientInfo 注册的客户端信息
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public MResponse registeToServer(@RequestBody ClientInfo clientInfo);



}
