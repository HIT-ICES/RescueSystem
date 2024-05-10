package com.hitices.localenvstatuswarner.bean;

import com.hitices.common.sensor.data.Environment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentBean {
    private Environment environment;
    private Date time;
}
