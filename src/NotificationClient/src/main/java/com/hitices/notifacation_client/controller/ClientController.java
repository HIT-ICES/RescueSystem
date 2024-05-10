package com.hitices.notifacation_client.controller;

import com.hitices.common.MResponse;
import com.hitices.notifacation_client.bean.Notice;
import com.hitices.notifacation_client.bean.message.Message;
import com.hitices.notifacation_client.service.ClientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 */
@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    @Qualifier("clientServiceImpl")
    private ClientService clientService;

    @PostMapping("receiveMessage")
    @ApiOperation(value = "接收信息")
    public MResponse receiveMessage(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            // TODO 本地消息处理逻辑
            System.out.println("接收到消息");
            System.out.println(notice.toString());
            return MResponse.successMResponse();
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }


    @PostMapping("sendMessage")
    @ApiOperation(value = "发送信息")
    public MResponse sendMessage(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            System.out.println("发送消息");
            clientService.sendMessage(notice);
            mResponse.setCode(200);
            mResponse.setStatus("success send");
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("radioToCLient")
    @ApiOperation(value = "广播所有客户端")
    public MResponse radioMessageToClient(@RequestBody Message message){
        MResponse mResponse = new MResponse();
        try {
            System.out.println("广播消息");
            clientService.radioToClient(message);
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("radioToServer")
    @ApiOperation(value = "广播所有服务端")
    public MResponse radioMessageToServer(@RequestBody Message message){
        MResponse mResponse = new MResponse();
        try {
            System.out.println("向server广播消息");
            clientService.radioToServer(message);
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("seeClients")
    @ApiOperation(value = "查看可以通信的对象")
    public MResponse seeClients(){
        MResponse mResponse = new MResponse();
        try {
            System.out.println("查看其他client");
            return clientService.seaOtherClient();
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }
}
