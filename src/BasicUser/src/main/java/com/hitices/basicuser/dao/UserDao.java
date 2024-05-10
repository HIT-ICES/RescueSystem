package com.hitices.basicuser.dao;

import com.hitices.basicuser.bean.User;
import com.hitices.basicuser.bean.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/2
 * 数据库中的Date为 sql库中的
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="basicuser")
public class UserDao {

    @Id
    private Integer userid;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="email")
    private String email;

    @Column(name="sex", nullable = false)
    private int sex;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="type", nullable = false)
    private int type;

    @Column(name="password", nullable = false)
    private String password;


    public static User getUser(UserDao userDao){
        User user = new User();
        user.setUserid(userDao.getUserid());
        user.setEmail(userDao.getEmail());
        user.setName(userDao.getName());
        user.setSex(userDao.getSex());
        user.setPhone(userDao.getPhone());
        user.setBirthday(new java.util.Date(userDao.getBirthday().getTime()));
        user.setUserType(UserType.getTypeByCode(userDao.getType()));
        user.setPassword(userDao.getPassword());
        return user;
    }


    public static UserDao getInstance(User user){
        return new UserDao(
                user.getUserid(),
                user.getName(),
                new Date(user.getBirthday().getTime()),
                user.getEmail(),
                user.getSex(),
                user.getPhone(),
                user.getUserType().getCode(),
                user.getPassword());
    }
}
