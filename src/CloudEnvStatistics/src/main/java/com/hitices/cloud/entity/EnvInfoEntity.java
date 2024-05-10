package com.hitices.cloud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "env_info", schema = "cloudenvdata", catalog = "")
public class EnvInfoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "data")
    private String data;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "time")
    private Date time;
    @Basic
    @Column(name = "position")
    private String position;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnvInfoEntity that = (EnvInfoEntity) o;
        return id == that.id && Objects.equals(data, that.data) && Objects.equals(status, that.status) && Objects.equals(time, that.time) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, status, time, position);
    }
}
