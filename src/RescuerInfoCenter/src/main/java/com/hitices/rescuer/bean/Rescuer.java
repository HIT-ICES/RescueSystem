package com.hitices.rescuer.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/27 11:02
 * @desc
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rescuer {
    private Integer id;

    private String name;

    private String desc;

    private String type;

    private String status;
}
