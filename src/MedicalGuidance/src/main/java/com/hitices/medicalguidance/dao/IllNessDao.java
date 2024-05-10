package com.hitices.medicalguidance.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="illNess")
public class IllNessDao {


    @Id
    private String id;

    private int illType;

    private String date;

    private String text;

    private String startDate;


    private String endDate;

    private String patient;

    private String diagnosesIds;
}
