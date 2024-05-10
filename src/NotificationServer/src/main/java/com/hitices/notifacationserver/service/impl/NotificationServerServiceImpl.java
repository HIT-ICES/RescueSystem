package com.hitices.notifacationserver.service.impl;

import com.hitices.common.MResponse;
import com.hitices.notifacationserver.repository.ClientRepository;
import com.hitices.notifacationserver.bean.Notice;
import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.bean.machine.ServerInfo;
import com.hitices.notifacationserver.bean.machine.ServersInfo;
import com.hitices.notifacationserver.bean.message.Message;
import com.hitices.notifacationserver.bean.message.MessageType;
import com.hitices.notifacationserver.dao.ClientInfoDao;
import com.hitices.notifacationserver.service.NotificationServerService;
import com.hitices.notifacationserver.utils.EurekaUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
@Component
@Qualifier("notificationServerServiceImpl")
public class NotificationServerServiceImpl implements NotificationServerService {

    private static Logger logger = LogManager.getLogger(NotificationServerServiceImpl.class);


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EurekaUtils eurekaUtils;

    @Override
    @Async
    public void registerInfo(ClientInfo clientInfo) {
        // 注册信息
        String clientId = clientInfo.getClientId();

        Optional<ClientInfoDao> optionalClientInfoDao = clientRepository.findById(clientId);
        ClientInfoDao clientInfoDao = null;
        boolean a = false;
        if (!optionalClientInfoDao.isPresent()){
            // 新的一个机器
            logger.info("新机器注册");
            clientInfoDao = new ClientInfoDao();
            clientInfoDao.setClientid(clientId);
            clientInfoDao.setLocation("");
            logger.info("-------------" + clientInfoDao);
        }else{
            a = true;
            logger.info("老机器");
            clientInfoDao = optionalClientInfoDao.get();
            clientInfoDao.setClientid(clientId);
            clientInfoDao.setLocation("");
        }
        logger.info("----------------");
        clientInfoDao.setIp(null);
        clientInfoDao.setIfable(0);
        int times = 10;
        while (times >= 0){
            logger.info("进入循环");
            try {
                ServiceInstance serviceInstance = eurekaUtils.getServiceInsanceByClientId(clientId);
                if (serviceInstance != null){
                    clientInfoDao.setIp(serviceInstance.getHost());
                    clientInfoDao.setIfable(1);
                    break;
                }else {
                    Thread.sleep(10000);
                    times--;
                }
            }catch (Exception e){
                e.printStackTrace();
                times--;
            }
        }
        if (a){
            logger.info("删除");
            clientRepository.deleteById(clientId);
        }

        logger.info("数据库存储");
        clientRepository.save(clientInfoDao);
    }

    @Override
    public void radioToServer(Message message) {
        String locaId = ServerInfo.getInstance().getServerId();
        Notice notice = new Notice();
        notice.setMessage(message);
        notice.setMessageType(MessageType.getTypeByCode(5)); //
        notice.setSourceId(locaId);
        List<ServersInfo> list = eurekaUtils.getAllServerInfo();
        for (ServersInfo serversInfo: list){
            if (serversInfo.getServerId().equals(locaId)){
                continue;
            }
            notice.setTargetId(serversInfo.getServerId());
            MResponse mResponse = new RestTemplate().exchange(
                    "http://" + serversInfo.getIP() + ":8080/server/recieveMessage",
                    HttpMethod.POST,
                    new HttpEntity<>(notice, new HttpHeaders()),
                    MResponse.class
            ).getBody();
            if (mResponse.getCode() == 0){
                logger.info("广播成功 to " + serversInfo.getServerId());
            }
        }
    }

    @Override
    public void radioToClient(Message message) {
        String locaId = ServerInfo.getInstance().getServerId();
        Notice notice = new Notice();
        notice.setMessage(message);
        notice.setMessageType(MessageType.getTypeByCode(6)); //
        notice.setSourceId(locaId);
        List<ClientInfo> list = eurekaUtils.getAllCLientInfo();
        for (ClientInfo clientInfo : list){
            notice.setTargetId(clientInfo.getClientId());
            MResponse mResponse = new RestTemplate().exchange(
                    "http://" + clientInfo.getIp() + ":8080/client/receiveMessage",
                    HttpMethod.POST,
                    new HttpEntity<>(notice, new HttpHeaders()),
                    MResponse.class
            ).getBody();
            if (mResponse.getCode() == 0){
                logger.info("广播成功 " + clientInfo.getClientId());
            }
        }

    }
}
