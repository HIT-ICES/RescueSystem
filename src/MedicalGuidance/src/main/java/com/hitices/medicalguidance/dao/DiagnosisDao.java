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
@Table(name="Diagnosis")
public class DiagnosisDao {

    @Id
    private String id;

    private String illNessId;

    private String doctorId;

    private String result;

    private String medicine;

    private String check;

    private String date;

}
