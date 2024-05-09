package com.hitices.basicenvstatusinfer.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class EnvStatusBean {
    private String status;
    private Date time;

    public String getStatus() {
        return status;
    }

    public Date getTime() {
        return time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EnvStatusBean{" +
                "status='" + status + '\'' +
                ", time=" + time +
                '}';
    }
}
