package com.hitices.ocr.controller;

import com.hitices.common.MResponse;
import com.hitices.ocr.bean.*;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.tess4j.Tesseract;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @author septemberhx
 * @date 2021/7/6
 **/

@RestController
@RequestMapping(value = "/ocr")
public class OCRController {

    private static Logger logger = LogManager.getLogger(OCRController.class);

    @PostMapping(value = "/rec")
    @ResponseBody
    @ApiOperation("Do ocr to one image and return the result")
    public MResponse rec(@RequestBody OCROnceBean requestBean) {
        OCROnceResultBean resultBean = new OCROnceResultBean();
        List<String> supportedLangs = Arrays.asList("eng", "chi_sim", "chi_tra");
        if (supportedLangs.contains(requestBean.getLang())) {
            try {
                Tesseract tesseract = new Tesseract();
                tesseract.setLanguage(requestBean.getLang());
                resultBean.setText(this.ocrBase64Image(tesseract, requestBean.getData()));
            } catch (Exception e) {
                logger.error(e);
                resultBean.setErrorCode(-1);
            }
        } else {
            resultBean.setErrorCode(-2);
        }

        return MResponse.successMResponse().set("data", resultBean);
    }

    @PostMapping(value = "/recList")
    @ResponseBody
    @ApiOperation("Do ocr to an image list and result the results")
    public MResponse recList(@RequestBody OCRMultiBean requestBean) {
        OCRMultiResultBean resultBean = new OCRMultiResultBean();
        List<String> supportedLangs = Arrays.asList("eng", "chi_sim", "chi_tra");
        if (supportedLangs.contains(requestBean.getLang())) {
            List<String> results = new ArrayList<>();
            try {
                Tesseract tesseract = new Tesseract();
                tesseract.setLanguage(requestBean.getLang());
                for (String dataStr : requestBean.getDataList()) {
                    results.add(this.ocrBase64Image(tesseract, dataStr));
                }
            } catch (Exception e) {
                logger.error(e);
                resultBean.setErrorCode(-1);
            }
            resultBean.setTextList(results);
        } else {
            resultBean.setErrorCode(-2);
        }

        return MResponse.successMResponse().set("data", resultBean);
    }

    private String ocrBase64Image(Tesseract tesseract, String base64Str) {
        if (base64Str.contains("data:")) {
            base64Str = base64Str.substring(base64Str.indexOf(',') + 1);
        }

        String result = "";
        try {
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64Str);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(base64decodedBytes));
            result = tesseract.doOCR(image);
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }
}
