package com.hitices.basicmaterial.dao;

import com.hitices.basicmaterial.entity.MaterialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 20:37
 */
public interface MaterialRecordRepository extends JpaRepository<MaterialRecord, Integer> {
    List<MaterialRecord> findAllByOptUserId(Integer optUserId);

    void deleteAllByOptUserId(Integer optUserId);

    List<MaterialRecord> findAllByOptUserIdAndTimeBetween(Integer optUserId, Date start, Date end);
}
