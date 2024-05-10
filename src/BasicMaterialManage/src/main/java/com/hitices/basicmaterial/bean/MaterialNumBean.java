package com.hitices.basicmaterial.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 18:59
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialNumBean {
    private Integer materialId;
    private Long number;
    private Integer userId;
}
