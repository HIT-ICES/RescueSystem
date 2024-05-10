package com.hitices.envmonitor.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 16:02
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
public class EnvStatus {
    private Integer id;
    private String status;
    private Date time;
}
