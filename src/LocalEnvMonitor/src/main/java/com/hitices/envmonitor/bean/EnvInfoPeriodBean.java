package com.hitices.envmonitor.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 11:01
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
public class EnvInfoPeriodBean {
    private Date start;
    private Date end;
}
