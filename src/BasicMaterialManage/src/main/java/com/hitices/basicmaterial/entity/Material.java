package com.hitices.basicmaterial.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 18:34
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material")
public class Material {
    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;

    @Column(name = "m_name", unique = true)
    private String name;

    @Column(name = "m_desc")
    private String desc;

    @Column(name = "m_number", nullable = false)
    private Long number;

    @Column(name = "m_userId", nullable = false)
    private Integer userId;

    public Material(String name, String desc, Long number, Integer userId) {
        this.name = name;
        this.desc = desc;
        this.number = number;
        this.userId = userId;
    }
}
