package com.hitices.localenvstatuswarner.dao;

import com.hitices.localenvstatuswarner.entity.EnvStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<EnvStatus, InternalError> {
    List<EnvStatus> findAllByTimeBetween(Date start, Date end);

    List<EnvStatus> findAllByStatusNotAndTimeBetween(String status,Date start, Date end);
}
