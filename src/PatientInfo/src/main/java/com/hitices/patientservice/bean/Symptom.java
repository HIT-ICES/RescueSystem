package com.hitices.patientservice.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 * 症状
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "症状信息")
public class Symptom {

    //症状描述
    private String text;

    // 持续时间
    private Date startDate;

    // 截至时间
    private Date endDate;
}
