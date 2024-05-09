package com.hitices.ocr.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author septemberhx
 * @date 2021/7/6
 **/
@Getter
@Setter
public class OCRMultiResultBean {

    private List<String> textList;
    private int errorCode;

    public OCRMultiResultBean() {
    }

    public OCRMultiResultBean(List<String> textList, int errorCode) {
        this.textList = textList;
        this.errorCode = errorCode;
    }
}
