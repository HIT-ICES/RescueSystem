package com.hitices.envmonitor.service.feignService;

import com.hitices.common.MResponse;
import com.hitices.envmonitor.bean.SensorInfoSelectBean;
import com.hitices.envmonitor.bean.IdBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 14:35
 */
@FeignClient("http://basic-env-statistics:8080/statistic/data")
public interface StatisticService {
    @PostMapping("/select")
    MResponse selectByDate(@RequestBody SensorInfoSelectBean filter);
}
