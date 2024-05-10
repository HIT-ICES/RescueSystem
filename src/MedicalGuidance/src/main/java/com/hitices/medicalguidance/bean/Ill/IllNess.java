package com.hitices.medicalguidance.bean.Ill;

import com.hitices.medicalguidance.bean.user.Patient;
import com.hitices.medicalguidance.dao.IllNessDao;
import com.hitices.medicalguidance.re.DiagnosisRepository;
import com.hitices.medicalguidance.re.PatientRepository;
import com.hitices.medicalguidance.utils.TimeChange;
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


    private static IllNessDao getDao(IllNess illNess){
        IllNessDao illNessDao = new IllNessDao();
        illNessDao.setId(illNess.getId());
        illNessDao.setIllType(illNess.getIllType().getCode());
        illNessDao.setDate(TimeChange.getDateString(illNess.getDate()));
        illNessDao.setText(illNess.getSymptom().getText());
        illNessDao.setStartDate(TimeChange.getDateString(illNess.getSymptom().getStartDate()));
        illNessDao.setStartDate(TimeChange.getDateString(illNess.getSymptom().getEndDate()));
        illNessDao.setPatient(illNess.getPatient().getPatientId());
        String ids ="";
        for (int i = 0; i < illNess.getDiagnoses().size(); i++) {
            if (i == illNess.getDiagnoses().size() -1 ){
                ids = ids + illNess.getDiagnoses().get(i);
            }else{
                ids = ids + illNess.getDiagnoses().get(i) + ",";
            }
        }
        illNessDao.setDiagnosesIds(ids);
        return illNessDao;
    }

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private PatientRepository patientRepository;

    public IllNess getIll(IllNessDao illNessDao){
        IllNess illNess = new IllNess();
        illNess.setId(illNessDao.getId());
        illNess.setIllType(IllType.getTypeByCode(illNessDao.getIllType()));
        illNess.setDate(TimeChange.getDate(illNessDao.getDate()));
        String[] ids =illNessDao.getDiagnosesIds().split(",");
        List<Diagnosis> list = new ArrayList<>();
        for (int i = 0; i < ids.length-1; i++) {
            list.add(new Diagnosis().getDia(diagnosisRepository.findById(ids[i]).get()));
        }
        Symptom symptom = new Symptom(illNessDao.getText(), TimeChange.getDate(illNessDao.getStartDate()), TimeChange.getDate(illNessDao.getEndDate()));
        illNess.setSymptom(symptom);
        illNess.setPatient(Patient.getDoctor(patientRepository.getById(illNessDao.getPatient())));
        return illNess;
    }
}
