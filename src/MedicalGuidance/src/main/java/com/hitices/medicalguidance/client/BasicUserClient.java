package com.hitices.medicalguidance.client;

import com.hitices.common.MResponse;
import com.hitices.medicalguidance.bean.UserRecived;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/08
 */
@Component
@FeignClient(name = "BasicUser/user", url = "http://basic-user:8080/user")
public interface BasicUserClient {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MResponse addUser(@RequestBody UserRecived userRecived);



}
