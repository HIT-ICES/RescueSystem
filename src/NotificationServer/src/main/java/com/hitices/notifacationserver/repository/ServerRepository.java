package com.hitices.notifacationserver.repository;

import com.hitices.notifacationserver.dao.ServerInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/09/24
 *
 */
public interface ServerRepository extends JpaRepository<ServerInfoDao, String> {


    @Override
    <S extends ServerInfoDao> S save(S s);
}
