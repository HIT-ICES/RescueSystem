package com.hitices.rescuer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/27 15:45
 * @desc 救援人员状态类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name="rescuer_status")
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class RescuerStatus {
    @Id
    @Column(name = "rs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "re_status", nullable = false)
    private String status;

    @Column(name = "rs_desc")
    private String desc;

    @Column(name = "rs_time", nullable = false)
    @CreationTimestamp
    private Date time;

    @Column(name = "rs_location", nullable = false)
    private String location;

    @Column(name = "rs_rescuerId", nullable = false)
    private Integer rescuerId;

    public RescuerStatus(String status, String desc, String location, Integer rescuerId) {
        this.status = status;
        this.desc = desc;
        this.location = location;
        this.rescuerId = rescuerId;
    }
}
