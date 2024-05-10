package com.hitices.basicuser.Repository;

import com.hitices.basicuser.dao.UserDao;
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
public interface UserRepository extends JpaRepository<UserDao, Integer> {

    @Override
    Optional<UserDao> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    <S extends UserDao> S save(S s);


    @Override
    List<UserDao> findAll();
}
