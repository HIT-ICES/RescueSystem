package com.hitices.rescuer.service.impl;

import com.hitices.rescuer.dao.RescuerStatusRepository;
import com.hitices.rescuer.entity.RescuerStatus;
import com.hitices.rescuer.service.RescuerStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:52
 * @desc
 */
@Service
public class RescuerStatusServiceImpl implements RescuerStatusService {

    @Resource
    private RescuerStatusRepository rescuerStatusRepository;

    @Override
    public RescuerStatus insert(RescuerStatus rescuer) {
        return rescuerStatusRepository.save(rescuer);
    }

    @Override
    public List<RescuerStatus> selectByRescuerIdBetweenDate(Integer rescuerId, Date start, Date end) {
        return rescuerStatusRepository.findAllByRescuerIdAndTimeIsBetween(rescuerId, start, end);
    }

    @Override
    public List<RescuerStatus> selectByRescuerId(Integer rescuerId) {
        return rescuerStatusRepository.findAllByRescuerId(rescuerId);
    }

    @Override
    public void deleteById(Integer id) {
        rescuerStatusRepository.deleteById(id);
    }

    @Override
    public void deleteByRescuerId(Integer rescuerId) {
        rescuerStatusRepository.deleteAllByRescuerId(rescuerId);
    }
}
