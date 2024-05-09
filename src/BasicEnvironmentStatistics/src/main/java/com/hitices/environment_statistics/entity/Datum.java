package com.hitices.environment_statistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="Data")
public class Datum
{
    @GenericGenerator(name = "datumId", strategy = "uuid")
    @GeneratedValue(generator = "datumId")
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Type")
    private String type;
//从传感器数据字段【time】获取
    @Column(name = "UpdateTime")
    private Date updateTime;

    @Column(name="Value")
    @Lob
    public String value;
    public Datum()
    {

    }
}
