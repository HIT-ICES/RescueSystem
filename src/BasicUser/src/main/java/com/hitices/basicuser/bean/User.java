package com.hitices.basicuser.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/6/30
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userid;
    private String name;
    private Date birthday;
    private String email;
    private int sex;
    private String phone;

    private UserType userType;

    private String password;

}
