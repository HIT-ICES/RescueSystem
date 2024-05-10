package com.hitices.patientservice.service.impl;

import com.hitices.patientservice.bean.Patient;
import com.hitices.patientservice.client.ConnectServer;
import com.hitices.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 */
@Component
@Qualifier("patientServiceImpl")
public class PatientServiceImpl implements PatientService {


    @Autowired
    private ConnectServer connectServer;


    /**
     * 向服务端注册病人信息
     * @param patient
     */
    @Override
    public void addPatient(Patient patient) {

        connectServer.registerPatient(patient);
    }





    @Async
    @Override
    public void requestVideo(){
        // 获取远程指导视频
    }
}
