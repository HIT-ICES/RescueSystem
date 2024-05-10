package com.hitices.patientservice.controller;

import com.hitices.common.MResponse;
import com.hitices.patientservice.bean.IDbean;
import com.hitices.patientservice.bean.Patient;
import com.hitices.patientservice.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 * 患者信息
 */
@Api(tags = "patient controller")
@RestController
@RequestMapping("/api/v1/patientcontroller")
public class PatientController {

    @Autowired
    @Qualifier("patientServiceImpl")
    private PatientService patientService;


    @PostMapping("/add")
    @ApiOperation(value = "添加患者", httpMethod = "POST")
    public MResponse addPatientInfo(@RequestBody Patient patient){
        try {
            MResponse m = MResponse.successMResponse();
            patientService.addPatient(patient);
            return m;
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }


    // 获取病人的基本信息
    @PostMapping("/getPatientBasicInfo")
    @ApiOperation(value = "获取病人的基本信息", httpMethod = "POST")
    public MResponse getPatientInfo(@RequestBody IDbean iDbean){
        String name =iDbean.getName();
        String id = iDbean.getIdNum();
        try {
            MResponse m = MResponse.successMResponse();

            return m;
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }


    // 获取病人的病理
    @PostMapping("/getPatientillnessInfo")
    @ApiOperation(value = "获取病人的病理", httpMethod = "POST")
    public MResponse getPatientillnessInfo(@RequestBody IDbean iDbean){
        String name = iDbean.getName();
        String idNum = iDbean.getIdNum();
        try {
            MResponse m = MResponse.successMResponse();

            return m;
        }catch (Exception e){
            return MResponse.failedMResponse();
        }
    }
}
