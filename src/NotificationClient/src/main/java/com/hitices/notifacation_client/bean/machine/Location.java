package com.hitices.notifacation_client.bean.machine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String location;
    // 经纬度
    private double lat;
    private double lng;
}
