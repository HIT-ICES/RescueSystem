package com.hitices.basicmaterial.service.impl;

import com.hitices.basicmaterial.bean.RecordBean;
import com.hitices.basicmaterial.dao.MaterialRecordRepository;
import com.hitices.basicmaterial.dao.MaterialRepository;
import com.hitices.basicmaterial.entity.Material;
import com.hitices.basicmaterial.entity.MaterialRecord;
import com.hitices.basicmaterial.service.MaterialRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 20:49
 */

@Service
public class MaterialRecordServiceImpl implements MaterialRecordService {

    @Resource
    private MaterialRecordRepository materialRecordRepository;

    @Override
    public Integer addRecord(RecordBean bean) {
        return materialRecordRepository.save(new MaterialRecord(
                bean.getMaterialId(),
                bean.getOperation(),
                bean.getOptValue(),
                bean.getOptUserId()
        )).getRecordId();
    }

    @Override
    public boolean deleteRecord(Integer recordId) {
        if (materialRecordRepository.existsById(recordId)) {
            materialRecordRepository.deleteById(recordId);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllRecordsByOptUserId(Integer optUserId) {
        materialRecordRepository.deleteAllByOptUserId(optUserId);
    }

    @Override
    public Optional<MaterialRecord> getByRecordId(Integer recordId) {
        return materialRecordRepository.findById(recordId);
    }

    @Override
    public List<MaterialRecord> getAllRecordsByOptUserId(Integer optUserId) {
        return materialRecordRepository.findAllByOptUserId(optUserId);
    }

    @Override
    public List<MaterialRecord> getAllRecordsByOptUserIdBetween(Integer optUserId, Date start, Date end) {
        return materialRecordRepository.findAllByOptUserIdAndTimeBetween(optUserId, start, end);
    }
}
