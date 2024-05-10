package com.hitices.notifacation_client.service.Impl;

import com.hitices.common.MResponse;
import com.hitices.notifacation_client.bean.Notice;
import com.hitices.notifacation_client.bean.machine.ClientInfo;
import com.hitices.notifacation_client.bean.message.Message;
import com.hitices.notifacation_client.bean.message.MessageType;
import com.hitices.notifacation_client.server.ForwarMessageFeign;
import com.hitices.notifacation_client.server.Op;
import com.hitices.notifacation_client.server.ServerConnectFeign;
import com.hitices.notifacation_client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
@Component
@Qualifier("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ServerConnectFeign serverConnectFeign;


    @Autowired
    private ForwarMessageFeign forwarMessageFeign;


    @Autowired
    private Op op;

    List<Notice> recieveMessage = new ArrayList<>();

    @Override
    public void sendMessage(Notice notice) {
        notice.setSourceId(ClientInfo.getInstance().getClientId());
        if (notice.getMessageType().getCode() == 1){
            // 转发操作
            forwarMessageFeign.forwardOne(notice);
        }else if(notice.getMessageType().getCode() == 0){
            serverConnectFeign.sendMessage(notice);
        }
    }

    @Override
    public void recieveMessage(Notice notice) {
        //
        recieveMessage.add(notice);
    }

    @Override
    public void radioToClient(Message message) {
        Notice notice = new Notice();
        notice.setMessage(message);
        notice.setSourceId(ClientInfo.getInstance().getClientId());
        notice.setTargetId("client");
        notice.setMessageType(MessageType.getTypeByCode(3));
        forwarMessageFeign.radioToClient(notice);
    }

    @Override
    public void radioToServer(Message message) {
        Notice notice = new Notice();
        notice.setMessage(message);
        notice.setSourceId(ClientInfo.getInstance().getClientId());
        notice.setTargetId("serverId");
        notice.setMessageType(MessageType.getTypeByCode(4));
        forwarMessageFeign.radioToClient(notice);
    }

    @Override
    public MResponse seaOtherClient() {
        return op.getAllClientInfo();
    }
}
