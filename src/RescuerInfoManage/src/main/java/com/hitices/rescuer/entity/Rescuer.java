package com.hitices.rescuer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/27 15:45
 * @desc 救援人员类
 */
@Entity
@Table(name="rescuer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Rescuer {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "r_name", unique = true)
    private String name;

    @Column(name = "r_desc")
    private String desc;

    @Column(name = "r_type", nullable = false)
    private String type;

    @Column(name = "r_status", nullable = false)
    private String status;

    public Rescuer(String name, String type, String desc, String status) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.status = status;
    }
}
