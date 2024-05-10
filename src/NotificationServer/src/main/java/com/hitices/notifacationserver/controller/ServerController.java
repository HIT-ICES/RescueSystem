package com.hitices.notifacationserver.controller;

import com.hitices.common.MResponse;
import com.hitices.notifacationserver.bean.Notice;
import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.bean.message.Message;
import com.hitices.notifacationserver.service.NotificationServerService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 */

@RestController
@RequestMapping("server")
@EnableAsync
public class ServerController {

    private static Logger logger = LogManager.getLogger(ServerController.class);

    @Autowired
    @Qualifier("notificationServerServiceImpl")
    private NotificationServerService notificationServerService;

    @PostMapping("register")
    @ApiOperation(value = "注册客户端")
    public MResponse registerClient(@RequestBody ClientInfo clientInfo){
        MResponse mResponse = new MResponse();
        try {
            logger.info("注册信息0-----------------" + clientInfo.toString());
            notificationServerService.registerInfo(clientInfo);
            mResponse.setStatus("success register");
            mResponse.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            return MResponse.failedMResponse();
        }
        return mResponse;
    }

    @PostMapping("recieveMessage")
    @ApiOperation(value = "接收信息")
    public MResponse recieveMessage(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            logger.info("接收到的消息为");
            logger.info(notice);
            mResponse.setStatus("success register");
            mResponse.setCode(200);
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("sendMessage")
    @ApiOperation(value = "发送信息")
    public MResponse sendMessage(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            mResponse.setCode(200);
            mResponse.setStatus("success send");
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("radioToServer")
    public MResponse radioToServer(@RequestBody Message message){
        // 广播所有的服务端
        try {
            logger.info("server 向 Server广播");
            logger.info(message);
            MResponse mResponse = MResponse.successMResponse();
            notificationServerService.radioToServer(message);
            return mResponse;

        }catch (Exception e){
            e.printStackTrace();
            return MResponse.failedMResponse();
        }
    }

    @PostMapping("radioToClient")
    public MResponse radioToClient(@RequestBody Message message){
        // 广播所有的客户端
        try {
            logger.info("server 向 client 广播");
            logger.info(message);
            MResponse mResponse = MResponse.successMResponse();
            notificationServerService.radioToClient(message);

            return mResponse;
        }catch (Exception e){
            e.printStackTrace();
            return MResponse.failedMResponse();
        }
    }


}
