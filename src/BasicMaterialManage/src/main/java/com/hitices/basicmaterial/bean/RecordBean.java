package com.hitices.basicmaterial.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 20:39
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordBean {
    private Integer materialId;
    private String operation;
    private Long optValue;
    private Integer optUserId;
}
