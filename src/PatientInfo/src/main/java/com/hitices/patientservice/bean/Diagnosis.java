package com.hitices.patientservice.bean;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/07
 * 诊断单
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "诊断信息")
public class Diagnosis {

    private String id;

    // 病症
    private String illNessId;


    //医生信息
    private Doctor doctor;

    // 诊断结果
    private String result;

    // 使用那些药物
    private List<String> medicine;

    //做那些检查
    private List<String> check;

    // 回执时间
    private Date date;



}
