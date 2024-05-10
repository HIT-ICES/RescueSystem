package com.hitices.medicalguidance.bean.Ill;

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
public class Symptom {


    //症状描述
    private String text;

    // 持续时间
    private Date startDate;

    // 截至时间
    private Date endDate;
}
