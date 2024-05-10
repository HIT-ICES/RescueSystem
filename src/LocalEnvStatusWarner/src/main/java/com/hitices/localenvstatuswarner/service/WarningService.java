package com.hitices.localenvstatuswarner.service;

import com.hitices.common.MResponse;
import com.hitices.common.sensor.data.Environment;
import com.hitices.localenvstatuswarner.entity.EnvStatus;

public interface WarningService {
    EnvStatus getStatus(Environment environment);

    MResponse reportStatus(EnvStatus envStatus);

    MResponse notifyWarning(EnvStatus envStatus);
}
