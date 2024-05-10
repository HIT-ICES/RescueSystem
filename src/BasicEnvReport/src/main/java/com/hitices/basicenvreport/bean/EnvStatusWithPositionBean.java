package com.hitices.basicenvreport.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvStatusWithPositionBean {
    private String status;
    private String position;
    private Date time;

    public void setTime(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        this.time = simpleDateFormat.parse(time,pos);
    }

    @Override
    public String toString() {
        return "EnvStatusWithPositionBean{" +
                "status='" + status + '\'' +
                ", position='" + position + '\'' +
                ", time=" + time +
                '}';
    }
}
