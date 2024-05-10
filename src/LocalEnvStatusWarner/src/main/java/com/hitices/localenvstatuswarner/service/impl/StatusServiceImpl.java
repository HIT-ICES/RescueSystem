package com.hitices.localenvstatuswarner.service.impl;

import com.hitices.localenvstatuswarner.bean.DataBean;
import com.hitices.localenvstatuswarner.client.BasicEnvReportClient;
import com.hitices.localenvstatuswarner.client.BasicWarningReportClient;
import com.hitices.localenvstatuswarner.client.EnvStatusInferClient;
import com.hitices.localenvstatuswarner.dao.StatusRepository;
import com.hitices.localenvstatuswarner.entity.EnvStatus;
import com.hitices.localenvstatuswarner.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("StatusServiceImpl")
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public EnvStatus save(EnvStatus envStatus) {
        if (envStatus!=null)
            return statusRepository.save(envStatus);
        else
            return null;
    }

    @Override
    public List<EnvStatus> findAllByTime(DataBean dataBean) {
        return statusRepository.findAllByTimeBetween(dataBean.getStart(),dataBean.getEnd());
    }

    @Override
    public List<EnvStatus> findWarningByTime(DataBean dataBean) {
        return statusRepository.findAllByStatusNotAndTimeBetween("Normal", dataBean.getStart(), dataBean.getEnd());
    }
}
