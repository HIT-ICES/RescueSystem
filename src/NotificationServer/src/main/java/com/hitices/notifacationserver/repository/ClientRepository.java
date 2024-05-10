package com.hitices.notifacationserver.repository;

import com.hitices.notifacationserver.dao.ClientInfoDao;
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
public interface ClientRepository extends JpaRepository<ClientInfoDao, String> {

    @Override
    Optional<ClientInfoDao> findById(String clientId);

    @Override
    <S extends ClientInfoDao> S save(S s);

    @Override
    List<ClientInfoDao> findAll();


    @Override
    void deleteById(String s);
}
