package com.hitices.medicalguidance.bean.Ill;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 */
public enum  IllType {


    // 内科
    INTERNALMEDECINE(1),

    // 外科
    SURGERY(2),

    //中医科
    TRADITIONALCHINESEMEDICINEDEPARTMENT(3),

    // 骨科
    ORTHOPAEDICS(4),

    //皮肤科
    DERMATOLOGY(5);





    int code;
    IllType(int code) {
        this.code = code;
    }
    public Integer getCode(){
        return this.code;
    }


    public static IllType getTypeByCode(int code){
        IllType[] list = IllType.values();
        for (int i = 0; i < list.length; i++) {
            if (list[i].getCode() == code){
                return list[i];
            }
        }
        return INTERNALMEDECINE;
    }
}
