package com.hitices.basicmaterial.dao;

import com.hitices.basicmaterial.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 18:46
 */
public interface MaterialRepository extends JpaRepository<Material, Integer> {

    boolean existsByUserId(Integer userId);

    Material findByUserId(Integer userId);

    void deleteByUserId(Integer userId);
}
