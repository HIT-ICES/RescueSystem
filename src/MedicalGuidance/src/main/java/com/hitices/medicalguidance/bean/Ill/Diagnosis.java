package com.hitices.medicalguidance.bean.Ill;

import com.hitices.medicalguidance.bean.Ill.IllNess;
import com.hitices.medicalguidance.bean.user.Doctor;
import com.hitices.medicalguidance.bean.user.Patient;
import com.hitices.medicalguidance.dao.DiagnosisDao;
import com.hitices.medicalguidance.re.DoctorRepository;
import com.hitices.medicalguidance.utils.TimeChange;
import com.sun.deploy.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    @Autowired
    private DoctorRepository doctorRepository;

    public DiagnosisDao getDao(Diagnosis diagnosis){
        return new DiagnosisDao(
                diagnosis.getId(),
                diagnosis.getIllNessId(),
                diagnosis.getDoctor().getId(),
                diagnosis.getResult(),
                StringUtils.join(Arrays.asList(diagnosis.getMedicine().toArray()), ","),
                StringUtils.join(Arrays.asList(diagnosis.getCheck().toArray()), ","),
                TimeChange.getDateString(diagnosis.getDate()));
    }

    public Diagnosis getDia(DiagnosisDao dao){
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setId(dao.getId());
        diagnosis.setDate(TimeChange.getDate(dao.getDate()));
        diagnosis.setIllNessId(dao.getIllNessId());
        diagnosis.setDoctor(Doctor.getDoctor(doctorRepository.findById(dao.getDoctorId()).get()));
        diagnosis.setResult(dao.getResult());
        diagnosis.setCheck(new ArrayList<String>(Arrays.asList(dao.getCheck().split(","))));
        diagnosis.setMedicine(new ArrayList<String>(Arrays.asList(dao.getMedicine().split(","))));
        return diagnosis;
    }


}
