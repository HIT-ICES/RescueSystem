package com.hitices.basicuser.service.Impl;

import com.hitices.basicuser.Repository.UserRepository;
import com.hitices.basicuser.bean.User;
import com.hitices.basicuser.bean.UserRecived;
import com.hitices.basicuser.dao.UserDao;
import com.hitices.basicuser.service.UserService;
import com.hitices.basicuser.utils.TimeChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/6/30
 */
@Component
@Qualifier("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void addUser(UserRecived userRecived) {
        UserDao userDao = new UserDao(
                0,
                userRecived.getName(),
                new Date(TimeChange.getDate(userRecived.getBirthday()).getTime()),
                userRecived.getEmail(),
                userRecived.getSex(),
                userRecived.getPhone(),
                userRecived.getType(),
                userRecived.getPassword());
        this.userRepository.save(userDao);
    }

    @Override
    public User getUserInfo(int userId) {
        return UserDao.getUser(userRepository.getOne(userId));
    }

    @Override
    public void removeUser(int userId) {
        userRepository.deleteById(userId);
    }


    @Override
    public User Login(String string, String password, String type) {
        List<UserDao> list = userRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (type.equals("email")){
                if (list.get(i).getEmail().equals(string) && list.get(i).getPassword().equals(password)){
                    return UserDao.getUser(list.get(i));
                }
            }else if(type.equals("tel")){
                if (list.get(i).getPhone().equals(string) && list.get(i).getPassword().equals(password)){
                    return UserDao.getUser(list.get(i));
                }
            }else{
                if (list.get(i).getName().equals(string) && list.get(i).getPassword().equals(password)){
                    return UserDao.getUser(list.get(i));
                }
            }
        }
        return null;
    }
}
