package com.hitices.basicuser.bean;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 */
public enum UserType {
    // 患者
    PATIENT(1),

    // 救援人员
    RESCUEWORKERS(2),

    // 管理员
    ADMIN(3),

    // 医疗专家
    MEDICALEXPERT(4);

    int code;

    UserType(int code){
        this.code = code;
    }


    public Integer getCode(){
        return this.code;
    }


    public static UserType getTypeByCode(int code){
        UserType[] userTypes = UserType.values();
        for (int i = 0; i < userTypes.length; i++) {
            if (userTypes[i].getCode() == code){
                return userTypes[i];
            }
        }
        return userTypes[0];
    }
}
