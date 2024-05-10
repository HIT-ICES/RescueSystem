package com.hitices.rescuer.service;

import com.hitices.rescuer.entity.Rescuer;

import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:50
 * @desc
 */
public interface RescuerService {
    Rescuer insertOrUpdate(Rescuer rescuer);

    Optional<Rescuer> select(Integer id);

    List<Rescuer> selectAll();

    void deleteById(Integer id);
}
