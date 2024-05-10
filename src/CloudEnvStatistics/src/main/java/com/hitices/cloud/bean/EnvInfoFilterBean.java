package com.hitices.cloud.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvInfoFilterBean {
    private String position;
    private Date start;
    private Date end;
}
