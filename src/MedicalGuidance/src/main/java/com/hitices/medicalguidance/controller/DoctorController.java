package com.hitices.medicalguidance.controller;

import com.hitices.common.MResponse;
import com.hitices.medicalguidance.bean.user.Doctor;
import com.hitices.medicalguidance.bean.user.Patient;
import com.hitices.medicalguidance.re.DoctorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/07
 */
@RestController
@RequestMapping("doctorController")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;


    //注册医生信息
    @PostMapping("registerDoctor")
    @ApiOperation("注册医生")
    public MResponse addPatientInfo(@RequestBody Doctor doctor){
        try {
            MResponse m = MResponse.successMResponse();

            return m;
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }
}
