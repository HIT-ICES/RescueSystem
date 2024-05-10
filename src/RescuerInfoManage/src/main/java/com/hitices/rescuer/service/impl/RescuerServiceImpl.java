package com.hitices.rescuer.service.impl;

import com.hitices.rescuer.dao.RescuerRepository;
import com.hitices.rescuer.entity.Rescuer;
import com.hitices.rescuer.service.RescuerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:52
 * @desc
 */
@Service
public class RescuerServiceImpl implements RescuerService {

    @Resource
    private RescuerRepository rescuerRepository;

    @Override
    public Rescuer insertOrUpdate(Rescuer rescuer) {
        return rescuerRepository.save(rescuer);
    }

    @Override
    public Optional<Rescuer> select(Integer id) {
        return rescuerRepository.findById(id);
    }

    @Override
    public List<Rescuer> selectAll() {
        return rescuerRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        rescuerRepository.deleteById(id);
    }
}
