package com.hitices.medicalguidance.service.impl;

import com.hitices.medicalguidance.bean.UserRecived;
import com.hitices.medicalguidance.bean.user.Patient;
import com.hitices.medicalguidance.client.BasicUserClient;
import com.hitices.medicalguidance.re.PatientRepository;
import com.hitices.medicalguidance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/08
 */
@Component
@Qualifier("PatientServiceImpl")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private BasicUserClient basicUserClient;

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public void insertInfo(Patient patient) {
        UserRecived userRecived = new UserRecived();

    }
}
