package com.hitices.notifacationserver.service.impl;

import com.hitices.common.MResponse;
import com.hitices.notifacationserver.bean.Notice;
import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.bean.machine.ServerInfo;
import com.hitices.notifacationserver.bean.machine.ServersInfo;
import com.hitices.notifacationserver.bean.message.MessageType;
import com.hitices.notifacationserver.service.ForwardService;
import com.hitices.notifacationserver.utils.EurekaUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/23
 */
@Component
@Qualifier("forwardServiceImpl")
public class ForwardServiceImpl implements ForwardService {

    private static Logger logger = LogManager.getLogger(ForwardServiceImpl.class);

    @Autowired
    private EurekaUtils eurekaUtils;

    @Async
    @Override
    public void forwordOne(Notice notice) {
        if (notice.getMessageType().equals(MessageType.CLIENT_TO_CLIENT)){
            ClientInfo clientInfo = eurekaUtils.getClientInfo(notice.getTargetId());
            String Ip = clientInfo.getIp();
            MResponse mResponse = new RestTemplate().exchange(
                    "http://" + Ip + ":8080/client/receiveMessage",
                    HttpMethod.POST,
                    new HttpEntity<>(notice, new HttpHeaders()),
                    MResponse.class
            ).getBody();
            if (mResponse.getCode() == 0){
                logger.info("relay success");
            }
        }
    }

    @Async
    @Override
    public void radioToClient(Notice notice) {
        if (notice.getMessageType().equals(MessageType.getTypeByCode(3))){
            List<ClientInfo> list = eurekaUtils.getAllCLientInfo();
            for (ClientInfo clientInfo : list){
                if (clientInfo.getClientId().equals(notice.getSourceId())){
                    continue;
                }
                notice.setTargetId(clientInfo.getClientId());
                String iP = clientInfo.getIp();
                MResponse mResponse = new RestTemplate().exchange(
                        "http://" + iP + ":8080/client/receiveMessage",
                        HttpMethod.POST,
                        new HttpEntity<>(notice, new HttpHeaders()),
                        MResponse.class
                ).getBody();
                if (mResponse.getCode() == 0){
                    logger.info("relay success");
                }
            }
        }
    }

    @Async
    @Override
    public void radioToServer(Notice notice) {
        List<ServersInfo> list = eurekaUtils.getAllServerInfo();
        for (ServersInfo serversInfo : list){
            if (serversInfo.getServerId().equals(ServerInfo.getInstance().getServerId())){
                continue;
            }
            String iP = serversInfo.getIP();
            notice.setTargetId(serversInfo.getServerId());
            MResponse mResponse = new RestTemplate().exchange(
                    "http://" + iP + ":8080/server/recieveMessage",
                    HttpMethod.POST,
                    new HttpEntity<>(notice, new HttpHeaders()),
                    MResponse.class
            ).getBody();
            if (mResponse.getCode() == 0){
                logger.info("relay success");
            }
        }
    }
}
