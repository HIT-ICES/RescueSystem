package com.hitices.notifacationserver.controller;

import com.hitices.common.MResponse;
import com.hitices.notifacationserver.bean.Notice;
import com.hitices.notifacationserver.service.ForwardService;
import com.hitices.notifacationserver.utils.EurekaUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/23
 * The call between clients completes the forwarding function
 */
@RestController
@RequestMapping("forward")
@EnableAsync
public class ForwardController {


    private static Logger logger = LogManager.getLogger(ForwardController.class);

    @Autowired
    @Qualifier("forwardServiceImpl")
    private ForwardService forwardService;

    @PostMapping("forwardOne")
    @ApiOperation(value = "异步转发客户端到客户端的信息")
    public MResponse forwardOne(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            forwardService.forwordOne(notice);
            mResponse.setStatus("success");
            mResponse.setCode(200);
            logger.info("relay the message");
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("radioToClient")
    @ApiOperation(value = "异步转发客户端到客户端的广播信息")
    public MResponse radioToClient(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            logger.info("广播到其他的Client");
            logger.info(notice.toString());
            logger.info(notice);
            mResponse.setStatus("success");
            mResponse.setCode(200);
            forwardService.radioToClient(notice);
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }


    @PostMapping("radioToServer")
    @ApiOperation(value = "异步转发客户端到服务端的广播信息")
    public MResponse radioToServer(@RequestBody Notice notice){
        MResponse mResponse = new MResponse();
        try {
            logger.info("广播到其他的server");
            logger.info(notice.toString());
            mResponse.setStatus("success");
            mResponse.setCode(200);
            forwardService.radioToServer(notice);
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
        return mResponse;
    }
}
