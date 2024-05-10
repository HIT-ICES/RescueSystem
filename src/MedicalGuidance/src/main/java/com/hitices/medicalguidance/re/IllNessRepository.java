package com.hitices.medicalguidance.re;

import com.hitices.medicalguidance.dao.DiagnosisDao;
import com.hitices.medicalguidance.dao.IllNessDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IllNessRepository extends JpaRepository<IllNessDao, String> {


    @Override
    Optional<IllNessDao> findById(String s);

    @Override
    List<IllNessDao> findAll();


    @Override
    <S extends IllNessDao> S save(S s);
}
