package com.hitices.medicalguidance.bean.user;

import com.hitices.medicalguidance.bean.Ill.IllType;
import com.hitices.medicalguidance.dao.DoctorDao;
import com.hitices.medicalguidance.dao.PatientDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 * 病人信息, 可以附带注册信息
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    // patient的id
    private String patientId;

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


    @Override
    public String toString() {
        return "";
    }




    public static PatientDao getDap(Patient patient){
        return new PatientDao(patient.getPatientId(), patient.getPatienName(), patient.getSex(), patient.getOld(), patient.getTelephoneNumber(), patient.getIdNumber());
    }

    public static Patient getDoctor(PatientDao patientDao){
        return new Patient(patientDao.getUserid(), patientDao.getPatienName(), patientDao.getSex(), patientDao.getOld(), patientDao.getTelephoneNumber(), patientDao.getIdNumber());
    }
}
