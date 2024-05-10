package com.hitices.medicalguidance.re;

import com.hitices.medicalguidance.dao.DoctorDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorDao, String> {

    @Override
    Optional<DoctorDao> findById(String s);


    @Override
    List<DoctorDao> findAll();

    @Override
    <S extends DoctorDao> S save(S s);

}
