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
@Table(name="serverinfo")
public class ServerInfoDao {
    
    @Id
    @Column(name = "serverid")
    private String serverid;
}
