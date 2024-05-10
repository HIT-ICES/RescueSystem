package com.hitices.envmonitor.dao;

import com.hitices.envmonitor.entity.EnvironmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 10:34
 * @desc
 */
public interface EnvInfoRepository extends JpaRepository<EnvironmentInfo, Integer> {
    List<EnvironmentInfo> findAllByTimeStampBetween(Date start, Date end);
}
