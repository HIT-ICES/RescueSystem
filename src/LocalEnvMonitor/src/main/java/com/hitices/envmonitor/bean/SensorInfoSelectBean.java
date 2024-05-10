package com.hitices.envmonitor.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 14:41
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorInfoSelectBean {
    private String type;
    private Date start;
    private Date end;

    public void setStart(String start) throws ParseException {
        this.start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
    }

    public void setEnd(String end) throws ParseException {
        this.end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
    }

}
