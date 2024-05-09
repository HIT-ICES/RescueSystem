package com.hitices.ocr.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author septemberhx
 * @date 2021/7/6
 **/
@Getter
@Setter
public class OCROnceBean {

    /**
        base64 encoded image
     */
    private String data;
    private String lang;

    public OCROnceBean() {
    }

    public OCROnceBean(String data, String lang) {
        this.data = data;
        this.lang = lang;
    }
}
