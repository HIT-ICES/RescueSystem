package com.hitices.notifacationserver.service;

import com.hitices.notifacationserver.bean.machine.ClientInfo;

import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
public interface OptionService {
    /**
     *  all client info
     * @return clients info
     */
    public List<ClientInfo> getAllClientInfo();

    /**
     * get client info by id
     * @param id client id
     * @return client info
     */
    public ClientInfo getClientInfoId(String id);



}
