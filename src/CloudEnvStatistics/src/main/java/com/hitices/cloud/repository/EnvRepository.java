package com.hitices.cloud.repository;

import com.hitices.cloud.entity.EnvInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface EnvRepository extends JpaRepository<EnvInfoEntity, InternalError> {

   EnvInfoEntity findByTimeAndPosition(Date time, String position);

   List<EnvInfoEntity> findByPositionAndTimeBetween(String position, Date start, Date end);
}
