package com.hitices.notifacationserver.init;

import com.hitices.notifacationserver.bean.machine.ServerInfo;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static Logger logger = LogManager.getLogger(InitClientId.class);

    private static String Id_path = "/id_path/id";

//    @Qualifier("eurekaApplicationInfoManager")
//    @Autowired
//    private ApplicationInfoManager applicationInfoManager;

    @Override
    public void run(String... args) throws Exception {
        File file = new File(Id_path);
        String serverId;
        if (file.exists()){
            serverId = FileUtils.readFileToString(file);
            logger.info(serverId);
        }else{
            UUID uuid =UUID.randomUUID();
            serverId = uuid.toString();
            try{
                FileUtils.write(file, uuid.toString(), false);
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        ServerInfo.getInstance(serverId);
        Map<String, String> map = new HashMap();
        map.put("serverId", serverId);
        map.put("type", "server");
//        applicationInfoManager.registerAppMetadata(map);
        Thread.sleep(5000);
  }
}