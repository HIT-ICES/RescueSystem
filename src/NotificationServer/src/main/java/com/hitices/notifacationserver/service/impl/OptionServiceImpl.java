package com.hitices.notifacationserver.service.impl;

import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.service.OptionService;
import com.hitices.notifacationserver.utils.EurekaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
@Component
@Qualifier("optionServiceImpl")
public class OptionServiceImpl implements OptionService {

    @Autowired
    private EurekaUtils eurekaUtils;

    @Override
    public List<ClientInfo> getAllClientInfo() {
        return eurekaUtils.getAllCLientInfo();
    }

    @Override
    public ClientInfo getClientInfoId(String id) {
        return eurekaUtils.getClientInfo(id);
    }



}
