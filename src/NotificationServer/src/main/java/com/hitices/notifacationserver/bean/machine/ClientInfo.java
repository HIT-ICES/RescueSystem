package com.hitices.notifacationserver.bean.machine;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 *  client info
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientInfo{


    private String clientId;
    private Location location;

    private String ip;

    public ClientInfo(String clientId) {
        this.clientId = clientId;
    }

}
