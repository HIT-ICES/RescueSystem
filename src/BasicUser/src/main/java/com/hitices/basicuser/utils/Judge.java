package com.hitices.basicuser.utils;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/08
 */
public class Judge {

    public static boolean checkStrIsNum01(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
