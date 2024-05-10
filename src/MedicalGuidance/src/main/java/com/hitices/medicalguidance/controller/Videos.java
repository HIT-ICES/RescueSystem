package com.hitices.medicalguidance.controller;


import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/videos")
public class Videos {


    private static Logger logger = LogManager.getLogger(Videos.class);


    @PostMapping(value="/uploadFile")
    @ApiOperation("上传文件")
    public void uploadFile(@RequestParam("file")  MultipartFile file) {
        logger.info("上传文件==="+"\n");
        if (file.isEmpty()) {
            return;
        }

        String fileName = file.getOriginalFilename();
        String path = "/fileUpload/" +fileName;
        logger.info("保存文件绝对路径"+path+"\n");
        File dest = new File(path);
        if (dest.exists()) {
            return;
        }
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            logger.info("上传失败");
            e.printStackTrace();
        }
        return;
    }
}
