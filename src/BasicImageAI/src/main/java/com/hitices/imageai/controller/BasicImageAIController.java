package com.hitices.imageai.controller;

import com.hitices.common.MResponse;
import com.hitices.imageai.bean.BasicImgBase64Bean;
import com.hitices.imageai.util.MRequestUtils;
import com.hitices.imageai.util.MUrlUtils;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


/**
 * @author septemberhx
 * @date 2021/9/28
 **/

@RestController
@Api(value = "Hello Controller")
@RequestMapping(value = "/imageai")
public class BasicImageAIController {

    private Logger logger = LogManager.getLogger(BasicImageAIController.class);

    public BasicImageAIController() {
    }

    @PostMapping(value = "/detect")
    public MResponse detect(@RequestBody BasicImgBase64Bean imgBase64Bean) {
        BasicImgBase64Bean img_after = MRequestUtils.sendRequest(
                MUrlUtils.getRemoteUri("127.0.0.1", 12345, "/imageai/detect"),
                imgBase64Bean,
                BasicImgBase64Bean.class,
                RequestMethod.POST
        );
        MResponse response = MResponse.successMResponse();
        response.set("data", img_after);
        return response;

    }
}
