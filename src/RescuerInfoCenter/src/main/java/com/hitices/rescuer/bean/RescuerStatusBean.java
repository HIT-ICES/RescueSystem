package com.hitices.rescuer.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:58
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
public class RescuerStatusBean {
    private String status;
    private String desc;
    private String location;
    private Integer rescuerId;
}
