package com.hitices.medicalguidance.bean.user;

import com.hitices.medicalguidance.bean.Ill.IllType;
import com.hitices.medicalguidance.dao.DoctorDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/07
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private String id;

    // 医生姓名
    private String name;

    // 日期
    private String tel;

    // 身份证号码
    private String Number;

    // 医生的类别
    private IllType illType;


    public static DoctorDao getDap(Doctor doctor){
        DoctorDao doctorDao = new DoctorDao(doctor.getId(),doctor.getName(),doctor.getTel(), doctor.getNumber(), doctor.getIllType().getCode());
        return doctorDao;
    }

    public static Doctor getDoctor(DoctorDao doctorDao){
        return new Doctor(doctorDao.getId(), doctorDao.getName(), doctorDao.getTel(), doctorDao.getNumber(), IllType.getTypeByCode(doctorDao.getIllType()));
    }
}
