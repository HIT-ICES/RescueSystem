package com.hitices.envmonitor.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitices.common.MResponse;
import com.hitices.common.sensor.SensorType;
import com.hitices.common.sensor.data.Environment;
import com.hitices.common.sensor.data.HumidityData;
import com.hitices.common.sensor.data.TemperatureData;
import com.hitices.envmonitor.bean.SensorInfoSelectBean;
import com.hitices.envmonitor.service.feignService.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 15:00
 */
@Service
public class StatisticalDataService {
    @Resource
    private StatisticService statisticService;

    /**
     * get all data of a scheme between start and end date
     *
     * @param bean
     */
    public Environment getEnvData(SensorInfoSelectBean bean, Date now) {
        Environment environment = new Environment();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        objectMapper.setDateFormat(fmt);

        environment.setTp(getRandomTemperatureData(bean, objectMapper));
        environment.setHd(getRandomHumidityData(bean, objectMapper));
        environment.setTimestamp(now);
        return environment;
    }

    private TemperatureData getRandomTemperatureData(SensorInfoSelectBean bean, ObjectMapper objectMapper) {
        bean.setType(SensorType.TEMPERATURE.name());
        MResponse response = statisticService.selectByDate(bean);
        List<TemperatureData> temperatureDataList = objectMapper.convertValue(response.get("data"), new TypeReference<List<TemperatureData>>() {}) ;
        int size = temperatureDataList.size();
        if (size == 0) {
            return null;
        }
        return temperatureDataList.get(new Random().nextInt(size));
    }

    private HumidityData getRandomHumidityData(SensorInfoSelectBean bean, ObjectMapper objectMapper) {
        bean.setType(SensorType.HUMIDITY.name());
        MResponse response = statisticService.selectByDate(bean);
        List<HumidityData> humidityDataList = objectMapper.convertValue(response.get("data"), new TypeReference<List<HumidityData>>() {});
        int size = humidityDataList.size();
        if (size == 0) {
            return null;
        }
        return humidityDataList.get(new Random().nextInt(size));
    }
}
