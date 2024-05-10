package com.hitices.notifacation_client.Init;

import com.hitices.notifacation_client.bean.machine.ClientInfo;
import com.hitices.notifacation_client.bean.machine.Location;
import com.hitices.notifacation_client.server.ServerConnectFeign;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 */
@Component
@Order(1)
public class InitClientId implements CommandLineRunner {

    private static String Id_path = "/id_path/id";

    @Autowired
    private ServerConnectFeign serverConnectFeign;

    @Override
    public void run(String... args) throws Exception {
        File file = new File(Id_path);
        String clientId;
        if (file.exists()){
            clientId = FileUtils.readFileToString(file);
            System.out.println(clientId);
        }else{
            UUID uuid =UUID.randomUUID();
            clientId = uuid.toString();
            try{
                FileUtils.write(file, uuid.toString(), false);
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        ClientInfo clientInfo = ClientInfo.getInstance(clientId);
        clientInfo.setLocation(new Location());

        // TODO, 向Eureka注册中心 注册id信息
        Map<String, String> map = new HashMap();
        map.put("clientId", clientId);
        map.put("type", "client");
        try {
            System.out.println("insert medata success");
        }catch (Exception e){
            System.out.println("insert medata failed");
        }

        Thread.sleep(30000);
        com.hitices.notifacation_client.bean.ClientInfo clientInfo1 = new com.hitices.notifacation_client.bean.ClientInfo(clientInfo.getClientId(), clientInfo.getLocation(), clientInfo.getIp());
        serverConnectFeign.registeToServer(clientInfo1);
  }
}