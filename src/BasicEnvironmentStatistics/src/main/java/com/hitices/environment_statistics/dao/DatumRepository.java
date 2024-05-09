package com.hitices.environment_statistics.dao;

import com.hitices.environment_statistics.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DatumRepository extends JpaRepository<Datum, String>
{
    List<Datum> findAllByTypeAndUpdateTimeBetween(String type, Date start, Date end);

}
