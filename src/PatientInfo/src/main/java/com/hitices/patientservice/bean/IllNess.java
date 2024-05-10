package com.hitices.patientservice.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 * 病理单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IllNess {

    // id
    private String id;

    // 门诊类型
    private IllType illType;

    // 时间
    private Date date;

    //症状
    private Symptom symptom;


    // 属于哪一个病人
    private Patient patient;

    // 那性病理单 有回执
    private List<Diagnosis> diagnoses;


}
