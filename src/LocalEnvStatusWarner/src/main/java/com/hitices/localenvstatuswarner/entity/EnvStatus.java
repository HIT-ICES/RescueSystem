package com.hitices.localenvstatuswarner.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "status")
public class EnvStatus {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "time", nullable = false)
    private Date time;

    public EnvStatus() {

    }

    public EnvStatus(String status, Date time){
        this.status = status;
        this.time = time;
    }

    @Override
    public String toString() {
        return "EnvStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", time=" + time +
                '}';
    }
}
