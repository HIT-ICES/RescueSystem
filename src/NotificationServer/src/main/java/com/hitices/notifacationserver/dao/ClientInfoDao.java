package com.hitices.notifacationserver.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/22
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientinfo")
public class ClientInfoDao {

    @Id
    @Column(name = "clientid")
    private String clientid;

    @Column(name="location")
    private String location;

    @Column(name= "ip")
    private String ip;

    @Column(name="ifable") // 是否可用
    private int ifable;

}
