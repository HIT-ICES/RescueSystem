package com.hitices.patientservice.client;

import com.hitices.common.MResponse;
import com.hitices.patientservice.bean.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/11/03
 */
@Component
@FeignClient(name = "MedicalGuidance/api/v1/", url = "http://medical-guidance/api/v1/")
public interface ConnectServer {

    @RequestMapping(value = "patientCotroller/registerPatient", method = RequestMethod.POST)
    public MResponse registerPatient(@RequestBody Patient patient);

    @RequestMapping(value = "videos/uploadFile", method = RequestMethod.POST ,consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public void uploadFile(@RequestPart("file") MultipartFile file);
}
