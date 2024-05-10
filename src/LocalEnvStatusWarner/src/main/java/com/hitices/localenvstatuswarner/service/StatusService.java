package com.hitices.localenvstatuswarner.service;

import com.hitices.localenvstatuswarner.bean.DataBean;
import com.hitices.localenvstatuswarner.entity.EnvStatus;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    EnvStatus save(EnvStatus envStatus);

    List<EnvStatus> findAllByTime(DataBean dataBean);

    List<EnvStatus> findWarningByTime(DataBean dataBean);
}
