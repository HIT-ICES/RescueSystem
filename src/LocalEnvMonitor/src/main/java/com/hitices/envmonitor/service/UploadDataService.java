package com.hitices.envmonitor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.envmonitor.bean.EnvStatus;
import com.hitices.envmonitor.bean.SensorInfoSelectBean;
import com.hitices.envmonitor.entity.EnvironmentInfo;
import com.hitices.envmonitor.service.feignService.EnvStatusWarnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/15 10:47
 * @desc upload data and send message to message service
 */
//@Component
@Slf4j
@EnableScheduling
public class UploadDataService {

    @Value("${timing.min}")
    private Integer period;

    @Resource
    private StatisticalDataService envDataService;

    @Resource
    private EnvStatusWarnerService warnerService;

    @Resource
    private EnvInfoService infoService;

    /**
     * 定时获取数据上传，得到结果后保存到数据库
     */
    @Scheduled(cron = "${timing.cron}")
    public void scheduleUpLoadData() {
        long tempStamp = System.currentTimeMillis();
        Date nowDate = new Date(tempStamp);
        Date startDate = new Date(tempStamp - period * 60 * 1000);

        try {
            SensorInfoSelectBean selectBean = new SensorInfoSelectBean();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            selectBean.setStart(format.format(startDate) );
            selectBean.setEnd(format.format(nowDate));
            // 获取数据
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            Environment environment = envDataService.getEnvData(selectBean, fmt.parse(fmt.format(nowDate)));
            // 上传数据
            MResponse response = warnerService.reportEnvData(environment);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(fmt);

            String status;
            if (response.getCode() != 0) {
                log.error("上传数据后，获取环境状态失败");
                status = "fail_to_get_status";
            } else {
                 status = response.getData(EnvStatus.class).getStatus();
            }
            // 存储到数据库
            EnvironmentInfo envInfo = new EnvironmentInfo();
            envInfo.setEnvData(objectMapper.writeValueAsString(environment));
            envInfo.setStatus(status);
            envInfo.setTimeStamp(environment.getTimestamp());

            infoService.insert(envInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
