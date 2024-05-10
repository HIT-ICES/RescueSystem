package com.hitices.envmonitor.service.feignService;

import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/15 11:17
 * @desc
 */
@FeignClient("http://local-env-status-warner:8080")
public interface EnvStatusWarnerService {
    @PostMapping("/reportEnvData")
    MResponse reportEnvData(@RequestBody Environment environment);
}
