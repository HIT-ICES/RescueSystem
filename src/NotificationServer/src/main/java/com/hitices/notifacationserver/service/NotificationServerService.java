package com.hitices.notifacationserver.service;

import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.bean.message.Message;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
public interface NotificationServerService {


    public void registerInfo(ClientInfo clientInfo);

    public void radioToServer(Message message);

    public void radioToClient(Message message);
}
