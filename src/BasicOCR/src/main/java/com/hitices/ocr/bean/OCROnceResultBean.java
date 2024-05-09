package com.hitices.ocr.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author septemberhx
 * @date 2021/7/6
 **/
@Getter
@Setter
public class OCROnceResultBean {

    private String text;
    private int errorCode;

    public OCROnceResultBean() {
    }

    public OCROnceResultBean(String text, int errorCode) {
        this.text = text;
        this.errorCode = errorCode;
    }
}
