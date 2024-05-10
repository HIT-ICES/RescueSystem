package com.hitices.basicmaterial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 20:21
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "m_record")
public class MaterialRecord {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "material_id", nullable = false)
    private Integer materialId;

    @Column(name = "opt_name", nullable = false)
    private String operation;

    @Column(name = "opt_value")
    private Long optValue;

    @Column(name = "opt_user_id", nullable = false)
    private Integer optUserId;

    @Column(name = "opt_time", nullable = false)
    @CreatedDate
    private Date time;

    public MaterialRecord(Integer materialId, String operation, Long optValue, Integer optUserId) {
        this.materialId = materialId;
        this.operation = operation;
        this.optUserId = optUserId;
        this.optValue = optValue;
    }
}
