package com.hitices.envmonitor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.envmonitor.bean.EnvInfoIdBean;
import com.hitices.envmonitor.bean.EnvInfoPeriodBean;
import com.hitices.envmonitor.bean.EnvInfoBean;
import com.hitices.envmonitor.entity.EnvironmentInfo;
import com.hitices.envmonitor.service.EnvInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 16:05
 */
@RestController
@RequestMapping("/envmonitor")
public class EnvInfoController {

    @Resource
    private EnvInfoService envInfoService;

    @PostMapping("/getByEnvInfoId")
    @ApiOperation(httpMethod = "POST",value = "根据ID获取环境信息")
    public MResponse getEnvInfoById(@RequestBody EnvInfoIdBean idBean) {
        if (idBean == null || idBean.getId() == null) {
            return MResponse.failedMResponse().set("msg", "传入参数错误！");
        }

        try {
            EnvironmentInfo envInfo = envInfoService.selectById(idBean.getId());
            if (envInfo == null) {
                throw new IllegalArgumentException("当前Id找不到匹配的环境信息！");
            }
            EnvInfoBean envBean = mapFromEnvInfo(envInfo);
            return MResponse.successMResponse().set("data", envBean);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("msg", e.getMessage());
        }

    }

    @PostMapping("/getByPeriod")
    @ApiOperation(httpMethod = "POST",value = "根据时间范围获取环境信息")
    public MResponse getEnvInfoByPeriod(@RequestBody EnvInfoPeriodBean periodBean) {
        if (periodBean == null || periodBean.getStart() == null || periodBean.getEnd() == null) {
            return MResponse.failedMResponse().set("msg", "传入参数错误！");
        }

        try {
            List<EnvironmentInfo> envInfoList = envInfoService.selectAllBetweenDate(periodBean.getStart(), periodBean.getEnd());
            List<EnvInfoBean> envBeanList = new ArrayList<>();

            for (EnvironmentInfo envInfo : envInfoList) {
                envBeanList.add(mapFromEnvInfo(envInfo));
            }

            return MResponse.successMResponse().set("data", envBeanList);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("msg", e.getMessage());
        }
    }

    private EnvInfoBean mapFromEnvInfo(EnvironmentInfo envInfo) throws JsonProcessingException {
        if (envInfo == null) {
            throw new IllegalArgumentException("envInfo is null");
        }
        EnvInfoBean envBean = new EnvInfoBean();
        envBean.setEnvInfoId(envInfo.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        objectMapper.setDateFormat(fmt);

        envBean.setEnvironment(objectMapper.readValue(envInfo.getEnvData(), Environment.class));
        envBean.setDateTime(envInfo.getTimeStamp());

        return envBean;
    }
}
