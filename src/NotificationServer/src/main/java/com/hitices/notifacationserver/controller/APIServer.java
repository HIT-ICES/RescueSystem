package com.hitices.notifacationserver.controller;

import com.hitices.common.MResponse;
import com.hitices.notifacationserver.bean.IDbean;
import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.service.OptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 * 对外界用户提供的对Client的操作接口
 */
@RestController
@RequestMapping("operation")
public class APIServer {

    @Autowired
    @Qualifier("optionServiceImpl")
    private OptionService optionService;


    @PostMapping("getAllClientInfo")
    @ApiOperation(value = "获取所有的客户端信息")
    public MResponse getAllClientInfo(){
        MResponse mResponse = new MResponse();
        try {
            List<ClientInfo> list = optionService.getAllClientInfo();
            mResponse.set("data", list);
        }catch (Exception e){
            e.printStackTrace();
            mResponse.setStatus("failed");
            mResponse.setCode(500);
        }
        return mResponse;
    }


    @PostMapping("/getClientInfoById")
    @ApiOperation(value = "根据ID获取指定的的客户端信息")
    public MResponse getClientInfoById(@RequestBody IDbean iDbean){
        String id = iDbean.getId();
        MResponse mResponse = new MResponse();
        try {
            mResponse.setCode(200);
            mResponse.set("data", optionService.getClientInfoId(id));
        }catch (Exception e){
            e.printStackTrace();
            mResponse.setCode(500);
            mResponse.setStatus("failed");
        }
        return mResponse;
    }
}
