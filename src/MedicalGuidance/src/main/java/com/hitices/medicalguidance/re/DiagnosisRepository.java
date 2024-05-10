package com.hitices.medicalguidance.re;


import com.hitices.medicalguidance.dao.DiagnosisDao;
import com.hitices.medicalguidance.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisDao, String> {


    @Override
    <S extends DiagnosisDao> S save(S s);

    @Override
    Optional<DiagnosisDao> findById(String s);

    @Override
    List<DiagnosisDao> findAll();

}
