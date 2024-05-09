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
public class OCRMultiBean {

    private String lang;
    private List<String> dataList;

    public OCRMultiBean() {
    }

    public OCRMultiBean(String lang, List<String> dataList) {
        this.lang = lang;
        this.dataList = dataList;
    }
}
