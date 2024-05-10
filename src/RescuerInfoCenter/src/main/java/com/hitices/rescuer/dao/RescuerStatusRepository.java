package com.hitices.rescuer.dao;


import com.hitices.rescuer.entity.RescuerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:48
 * @desc
 */
public interface RescuerStatusRepository extends JpaRepository<RescuerStatus, Integer> {
    List<RescuerStatus> findAllByRescuerId(Integer rescuerId);

    List<RescuerStatus> findAllByRescuerIdAndTimeIsBetween(Integer rescuerId, Date start, Date end);

    void deleteAllByRescuerId(Integer rescuerId);
}
