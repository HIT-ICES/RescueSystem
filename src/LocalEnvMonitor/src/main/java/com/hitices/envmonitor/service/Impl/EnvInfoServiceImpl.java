package com.hitices.envmonitor.service.Impl;

import com.hitices.envmonitor.dao.EnvInfoRepository;
import com.hitices.envmonitor.entity.EnvironmentInfo;
import com.hitices.envmonitor.service.EnvInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 10:42
 * @desc
 */
@Service
public class EnvInfoServiceImpl implements EnvInfoService {

    @Resource
    private EnvInfoRepository envInfoRepository;

    @Override
    public List<EnvironmentInfo> selectAll() {
        return envInfoRepository.findAll();
    }

    @Override
    public EnvironmentInfo selectById(Integer infoId) {
        return envInfoRepository.findById(infoId).orElse(null);
    }

    @Override
    public List<EnvironmentInfo> selectAllBetweenDate(Date start, Date end) {
        return envInfoRepository.findAllByTimeStampBetween(start, end);
    }

    @Override
    public EnvironmentInfo insert(EnvironmentInfo envInfo) {
        return envInfoRepository.save(envInfo);
    }

    @Override
    public void deleteById(Integer infoId) {
        envInfoRepository.deleteById(infoId);
    }
}
