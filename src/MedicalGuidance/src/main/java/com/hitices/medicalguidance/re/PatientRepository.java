package com.hitices.medicalguidance.re;

import com.hitices.medicalguidance.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/2
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientDao, String> {

    @Override
    Optional<PatientDao> findById(String integer);

    @Override
    void deleteById(String s);

    @Override
    <S extends PatientDao> S save(S s);


    @Override
    List<PatientDao> findAll();
}
