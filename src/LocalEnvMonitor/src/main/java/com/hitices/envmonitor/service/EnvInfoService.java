package com.hitices.envmonitor.service;

import com.hitices.envmonitor.entity.EnvironmentInfo;

import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 10:40
 * @desc
 */
public interface EnvInfoService {
    List<EnvironmentInfo> selectAll();

    EnvironmentInfo selectById(Integer infoId);

    List<EnvironmentInfo> selectAllBetweenDate(Date start, Date end);

    EnvironmentInfo insert(EnvironmentInfo envInfo);

    void deleteById(Integer infoId);
}
