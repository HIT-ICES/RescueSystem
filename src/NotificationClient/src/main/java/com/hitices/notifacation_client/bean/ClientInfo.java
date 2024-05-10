package com.hitices.notifacation_client.bean;

import com.hitices.notifacation_client.bean.machine.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo{

    private String clientId;
    // 该客户端的位置
    private Location location;

    private String ip;


}
