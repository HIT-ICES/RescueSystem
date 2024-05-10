package com.hitices.medicalguidance.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/2
 */

@Getter
@Setter
@NoArgsConstructor
public class UserRecived {
    private int userid;
    private String name;
    private String birthday;
    private String email;
    private int sex;
    private String phone;
    private int type;
    private String password;
}