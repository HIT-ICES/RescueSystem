package com.hitices.notifacationserver.bean.machine;

import lombok.Getter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/23
 * server info
 */
@Getter
public class ServerInfo {

    private static volatile ServerInfo serverInfo;


    private final String serverId;
    private ServerInfo(String serverId) {
        this.serverId = serverId;
    }

    public static ServerInfo getInstance(String serverId) {
        if (serverInfo == null){
            synchronized (ServerInfo.class){
                if (serverInfo == null){
                    return new ServerInfo(serverId);
                }
            }
        }
        return serverInfo;
    }

    public static ServerInfo getInstance() {
        return serverInfo;
    }


}
