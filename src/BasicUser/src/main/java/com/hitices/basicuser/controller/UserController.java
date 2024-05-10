package com.hitices.basicuser.controller;

import com.hitices.basicuser.bean.IDbean;
import com.hitices.basicuser.bean.LoginBean;
import com.hitices.basicuser.bean.User;
import com.hitices.basicuser.bean.UserRecived;
import com.hitices.basicuser.service.UserService;
import com.hitices.basicuser.utils.Judge;
import com.hitices.common.MResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/6/30
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @GetMapping("/welcome")
    @ApiOperation("欢迎")
    public MResponse welcome(){
        MResponse mResponse = MResponse.successMResponse();
        mResponse.setStatus("welcome to use BasicUser Microservice");
        return mResponse;
    }

    @PostMapping("/getUserInfoById")
    @ApiOperation("得到用户信息")
    public MResponse getUserInfo(@RequestBody IDbean iDbean){
        Integer userId = iDbean.getId();
        MResponse mResponse = new MResponse();
        User user = null;
        int code = 1;
        String status = "get success";
        try {
             user = this.userService.getUserInfo(userId);
        }catch (Exception e){
            code = 0;
            status = "get failed";
        }
        mResponse.set("data", user);
        mResponse.setCode(code);
        mResponse.setStatus(status);
        return mResponse;
    }


    @PostMapping("/add")
    @ApiOperation("添加用户")
    public MResponse addUserInfo(@RequestBody UserRecived userRecived){
        MResponse mResponse = new MResponse();
        int code = 1;
        String status = "add success";
        try {
            this.userService.addUser(userRecived);
        }catch (Exception e){
            code = 0;
            status = "add failed";
        }
        mResponse.setCode(code);
        mResponse.setStatus(status);
        return mResponse;
    }

    @PostMapping("/remove")
    @ApiOperation("删除某一个用户")
    public MResponse deleteUser(@RequestBody IDbean iDbean) {
        Integer userId = iDbean.getId();
        MResponse mResponse = new MResponse();
        int code = 1;
        String status = "remove success";
        try {
            this.userService.removeUser(userId);
        }catch (Exception e){
            code = 0;
            status = "remove failed";
        }
        mResponse.setCode(code);
        mResponse.setStatus(status);
        return mResponse;
    }

    @PostMapping("login")
    @ApiOperation("登录")
    public MResponse login(@RequestBody LoginBean loginBean){
        String string = loginBean.getUsername();
        String password = loginBean.getPassword();
        MResponse mResponse = new MResponse();
        int code = 1;
        String status = "login success";
        try {
            User user = null;
            if (string.contains("@")){
                // 邮箱登陆
                user = userService.Login(string,password,"email");
            }else if(Judge.checkStrIsNum01(string)){
                user = userService.Login(string, password,"tel");
            }else{
                // 用户名字登陆
                user = userService.Login(string, password, "user");
            }
            if (user == null){
                code = 0;
                status = "login failed";
            }
        }catch (Exception e){
            code = 0;
            status = "login failed";
        }
        mResponse.setCode(code);
        mResponse.setStatus(status);
        return mResponse;
    }
}
