package com.hitices.medicalguidance.dao;

import com.hitices.medicalguidance.bean.Ill.IllType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/09
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="doctor")
public class DoctorDao {


    @Id
    private String id;

    // 医生姓名
    private String name;

    // 日期
    private String tel;

    // 身份证号码
    private String Number;

    // 医生的类别
    private int illType;


}
