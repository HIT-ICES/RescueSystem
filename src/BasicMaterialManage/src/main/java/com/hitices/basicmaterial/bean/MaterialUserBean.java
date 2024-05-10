package com.hitices.basicmaterial.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 22:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUserBean {
    private Integer materialId;
    private Integer userId;
}
