package com.hitices.medicalguidance.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/07
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patientInfo")
public class PatientDao {



    @Id
    private String userid;

    // 患者姓名
    private String patienName;

    //性别
    private int sex;

    //年龄
    private int old;

    //电话
    private String telephoneNumber;

    // 身份证号码
    private String idNumber;


}
