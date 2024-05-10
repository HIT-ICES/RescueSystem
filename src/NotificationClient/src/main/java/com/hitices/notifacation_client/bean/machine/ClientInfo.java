package com.hitices.notifacation_client.bean.machine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 * 表示 client 客户端的信息
 */
@Getter
@Setter
public class ClientInfo{

    private static volatile ClientInfo clientInfo;

    private final String clientId;
    // 该客户端的位置
    private Location location;

    private String ip;

    private ClientInfo(String clientId) {
        this.clientId = clientId;
    }

    private ClientInfo() {
        this.clientId = null;
    }


    // 全局唯一信息类
    public static ClientInfo getInstance(String clientId) {
        if (clientInfo == null){
            synchronized (ClientInfo.class){
                if (clientInfo == null){
                    clientInfo = new ClientInfo(clientId);
                }
            }
        }
        return clientInfo;
    }
    public static ClientInfo getInstance() {
        return clientInfo;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        location = location;
    }

    public ClientInfo Location(Location location){
        this.location = location;
        return this;
    }

}
