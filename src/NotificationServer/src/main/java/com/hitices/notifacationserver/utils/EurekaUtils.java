package com.hitices.notifacationserver.utils;

import com.hitices.notifacationserver.repository.ClientRepository;
import com.hitices.notifacationserver.bean.machine.ClientInfo;
import com.hitices.notifacationserver.bean.machine.Location;
import com.hitices.notifacationserver.bean.machine.ServersInfo;
import com.hitices.notifacationserver.dao.ClientInfoDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/09/24
 */
@Component
public class EurekaUtils {


    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private ClientRepository clientRepository;


    private static Logger logger = LogManager.getLogger(EurekaUtils.class);

    public List<ClientInfo> getAllCLientInfo(){
        List<ServiceInstance> list = discoveryClient.getInstances("NotificationServiceClient");
        List<ClientInfo> result = new ArrayList<>();
        for (ServiceInstance serviceInstance : list){
            ClientInfo clientInfo = getClientInfo(serviceInstance);
            Optional<ClientInfoDao> optionalClientInfoDao = clientRepository.findById(clientInfo.getClientId());
            if (!optionalClientInfoDao.isPresent()){
                ClientInfoDao clientInfoDao = new ClientInfoDao();
                clientInfoDao.setIfable(1);
                clientInfoDao.setLocation("");
                clientInfoDao.setClientid(clientInfo.getClientId());
                clientInfoDao.setIp(clientInfo.getIp());
                clientRepository.save(clientInfoDao);
            }
            String location = optionalClientInfoDao.isPresent()?optionalClientInfoDao.get().getLocation():"";
            Location location1 = new Location();
            location1.setLocation(location);
            clientInfo.setLocation(location1);
            result.add(clientInfo);
        }
        return result;
    }


    public List<ServersInfo> getAllServerInfo(){
        List<ServiceInstance> list = discoveryClient.getInstances("NotificationServiceServer");
        List<ServersInfo> list1 = new ArrayList<>();
        for (ServiceInstance serviceInstance : list){
            list1.add(new ServersInfo(serviceInstance.getMetadata().get("serverId"), serviceInstance.getHost()));
        }
        return list1;
    }


    public ServiceInstance getServiceInsanceByClientId(String clientId){
        List<ServiceInstance> list = discoveryClient.getInstances("NotificationServiceClient");
        logger.info("ServiceInstance: " + list.toString());
        for (ServiceInstance serviceInstance : list){
            try {
                logger.info("serviceInstance: " + serviceInstance.getMetadata());
                if (serviceInstance.getMetadata().get("clientId").equals(clientId)){
                    return serviceInstance;
                }
            }catch (Exception e){
                logger.error("null metada");
                return null;
            }

        }
        return null;
    }


    public ClientInfo getClientInfo(String clientId){
        List<ServiceInstance> list = discoveryClient.getInstances("NotificationServiceClient");
        for (ServiceInstance serviceInstance : list){
            if (serviceInstance.getMetadata().get("clientId").equals(clientId)){
                ClientInfo clientInfo = new ClientInfo(clientId);
                clientInfo.setIp(serviceInstance.getHost());
                Optional<ClientInfoDao> optionalClientInfoDao = clientRepository.findById(clientInfo.getClientId());
                if (!optionalClientInfoDao.isPresent()){
                    ClientInfoDao clientInfoDao = new ClientInfoDao();
                    clientInfoDao.setIfable(1);
                    clientInfoDao.setLocation("");
                    clientInfoDao.setClientid(clientInfo.getClientId());
                    clientInfoDao.setIp(clientInfo.getIp());
                    clientRepository.save(clientInfoDao);
                }
                String location = optionalClientInfoDao.isPresent()?optionalClientInfoDao.get().getLocation():"";
                Location location1 = new Location();
                location1.setLocation(location);
                clientInfo.setLocation(location1);
                return clientInfo;
            }
        }
        return null;
    }



    public ClientInfo getClientInfo(ServiceInstance serviceInstance){
        String clientId = serviceInstance.getMetadata().get("clientId");
        ClientInfo clientInfo = new ClientInfo(clientId);
        clientInfo.setIp(serviceInstance.getHost());
        return clientInfo;
    }
}
