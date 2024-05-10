package com.hitices.basicuser.service;

import com.hitices.basicuser.bean.User;
import com.hitices.basicuser.bean.UserRecived;

import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/6/30
 */
public interface UserService {


    void addUser(UserRecived userRecived);

    User getUserInfo(int userId);

    void removeUser(int userId);

    User Login(String string, String password, String type);
}
