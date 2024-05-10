package com.hitices.basicenvreport.service;

import com.hitices.basicenvreport.bean.EnvStatusBean;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;

public interface CloudService {
    /**
     * 环境数据上报
     * @param environment 环境数据
     */
    MResponse reportEnvData(Environment environment);
    /**
     * 环境状态上报
     * @param status 状态文本信息
     */
    MResponse reportEnvStatus(EnvStatusBean status);
}
