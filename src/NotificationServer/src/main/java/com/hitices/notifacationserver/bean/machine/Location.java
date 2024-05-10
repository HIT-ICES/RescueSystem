package com.hitices.notifacationserver.bean.machine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 * client location
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String location;
    private double lat;
    private double lng;
}
