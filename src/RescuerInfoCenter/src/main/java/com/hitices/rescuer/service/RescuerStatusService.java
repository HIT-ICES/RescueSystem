package com.hitices.rescuer.service;


import com.hitices.rescuer.entity.RescuerStatus;

import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:50
 * @desc
 */
public interface RescuerStatusService {
    RescuerStatus insert(RescuerStatus rescuer);

    List<RescuerStatus> selectByRescuerIdBetweenDate(Integer rescuerId, Date start, Date end);

    List<RescuerStatus> selectByRescuerId(Integer rescuerId);

    void deleteById(Integer id);

    void deleteByRescuerId(Integer rescuerId);
}
