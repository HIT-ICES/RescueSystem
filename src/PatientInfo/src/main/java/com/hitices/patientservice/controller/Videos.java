package com.hitices.patientservice.controller;


import com.hitices.patientservice.client.ConnectServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@Api(tags = "videos controller")
public class Videos {

    @Autowired
    private ConnectServer connectServer;

    @Autowired
    private RestTemplate restTemplate;

    private static Logger logger = LogManager.getLogger(Videos.class);


    @RequestMapping("/file")
    @ApiOperation(value = "查询文件")
    public String file(){
        logger.info("================请求路径===跳转file页面====="+"\n");
        return "file";
    }

    @RequestMapping(value="/uploadFile")
    @ApiOperation(value = "上传文件")
    public String uploadFile(@RequestParam("fileName") MultipartFile file) {
        logger.info("上传文件==="+"\n");
        if (file.isEmpty()) {
            return "file";
        }
        String fileName = file.getOriginalFilename();
        String path = "/fileUpload/" +fileName;
        File dest = new File(path);
        if (dest.exists()) {
            return "file";
        }
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            connectServer.uploadFile(file);
            file.transferTo(dest);
            logger.info("保存文件路径"+path+"\n");
        } catch (IOException e) {
            logger.info("上传失败");
            e.printStackTrace();
            return "file";
        }
        return "success";
    }

}
