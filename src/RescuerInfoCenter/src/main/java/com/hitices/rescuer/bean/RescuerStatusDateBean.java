package com.hitices.rescuer.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/27 11:26
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
public class RescuerStatusDateBean {
    private Integer rescuerId;
    private Date start;
    private Date end;
}
