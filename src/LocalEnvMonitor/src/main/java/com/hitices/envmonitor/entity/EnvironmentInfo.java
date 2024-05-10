package com.hitices.envmonitor.entity;

import com.hitices.common.sensor.data.HumidityData;
import com.hitices.common.sensor.data.TemperatureData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/12/16 10:17
 * @desc
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "envInfo")
public class EnvironmentInfo {
    @Id
    @Column(name = "e_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "e_sensorData")
    private String envData;

    @Column(name = "e_status")
    private String status;

    @Column(name = "e_timeStamp")
    private Date timeStamp;
}
