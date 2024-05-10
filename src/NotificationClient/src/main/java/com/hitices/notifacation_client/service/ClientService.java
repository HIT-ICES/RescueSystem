package com.hitices.notifacation_client.service;

import com.hitices.common.MResponse;
import com.hitices.notifacation_client.bean.Notice;
import com.hitices.notifacation_client.bean.message.Message;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 * 提供客户端的基础服务
 */
public interface ClientService {

    void sendMessage(Notice notice);

    void recieveMessage(Notice notice);

    void radioToClient(Message message);

    void radioToServer(Message message);

    MResponse seaOtherClient();
}
