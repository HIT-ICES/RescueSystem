package com.hitices.rescuer.dao;

import com.hitices.rescuer.entity.Rescuer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:48
 * @desc
 */
public interface RescuerRepository extends JpaRepository<Rescuer, Integer> {
}
