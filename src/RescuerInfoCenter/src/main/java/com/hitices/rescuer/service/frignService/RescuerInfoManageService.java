package com.hitices.rescuer.service.frignService;

import com.hitices.common.MResponse;
import com.hitices.rescuer.bean.IdBean;
import com.hitices.rescuer.bean.Rescuer;
import com.hitices.rescuer.bean.RescuerIdBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/27 10:58
 * @desc
 */
@FeignClient(name = "RescuerInfoManage", url = "http://rescuerinfomanage:8080/rescuer")
public interface RescuerInfoManageService {

    @PostMapping("/getById")
    MResponse selectById(@RequestBody IdBean bean);

    @PostMapping("/update")
    MResponse updateStatus(@RequestBody Rescuer rescuer);
}
