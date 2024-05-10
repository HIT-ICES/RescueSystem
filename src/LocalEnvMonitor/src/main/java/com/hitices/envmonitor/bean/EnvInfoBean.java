package com.hitices.envmonitor.bean;

import com.hitices.common.sensor.data.Environment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/15 11:22
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvInfoBean {
    Integer envInfoId;
    Environment environment;
    Date dateTime;
}
