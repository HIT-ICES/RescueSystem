package com.hitices.environment_statistics.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class SelectBean
{
    private String type;
    private Date start;
    private Date end;

    public void setStart(String start) throws ParseException
    {
        this.start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
    }

    public void setEnd(String end) throws ParseException {
        this.end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
    }
}
