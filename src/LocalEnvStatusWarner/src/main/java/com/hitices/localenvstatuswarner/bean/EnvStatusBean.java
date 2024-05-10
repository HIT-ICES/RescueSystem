package com.hitices.localenvstatuswarner.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class EnvStatusBean {
    private String status;
    private Date time;

    public EnvStatusBean() {

    }

    public void setTime(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        this.time = simpleDateFormat.parse(time,pos);
    }
}
