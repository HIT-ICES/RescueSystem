package com.hitices.basicmaterial.service.impl;

import com.hitices.basicmaterial.bean.MaterialBean;
import com.hitices.basicmaterial.bean.MaterialNumBean;
import com.hitices.basicmaterial.bean.MaterialUserBean;
import com.hitices.basicmaterial.dao.MaterialRecordRepository;
import com.hitices.basicmaterial.dao.MaterialRepository;
import com.hitices.basicmaterial.entity.Material;
import com.hitices.basicmaterial.service.MaterialRecordService;
import com.hitices.basicmaterial.service.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 19:52
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> getMaterialByUserId(Integer userId) {
        Material material = materialRepository.findByUserId(userId);
        return Optional.ofNullable(material);
    }

    @Override
    public Optional<Material> getMaterialById(MaterialUserBean bean) {
        return materialRepository.findById(bean.getMaterialId());
    }

    @Override
    public Integer addMaterial(MaterialBean materialBean) {
        return materialRepository.save(new Material(
                materialBean.getName(),
                materialBean.getDesc() == null ? "" : materialBean.getDesc(),
                materialBean.getNumber(),
                materialBean.getUserId()
        )).getMaterialId();
    }

    @Override
    public List<Integer> addMaterialList(List<MaterialBean> materialBean) {
        List<Integer> idList = new ArrayList<>();
        for (MaterialBean bean : materialBean) {
            idList.add(this.addMaterial(bean));
        }
        return idList;
    }

    @Override
    public boolean changeMaterialNumber(MaterialNumBean materialNumBean) {
        Optional<Material> materialOptional = materialRepository.findById(materialNumBean.getMaterialId());
        if (materialOptional.isPresent()) {
            Material material = materialOptional.get();
            // update number
            long num = material.getNumber() + materialNumBean.getNumber();
            if (num < 0) {
                return false;
            }
            material.setNumber(num);
            materialRepository.save(material);
            return true;
        }
        return false;
    }

    @Override
    public boolean putMaterial(MaterialNumBean materialNumBean) {
        return this.changeMaterialNumber(materialNumBean);
    }

    @Override
    public boolean takeMaterial(MaterialNumBean materialNumBean) {
        materialNumBean.setNumber(-materialNumBean.getNumber());
        return this.changeMaterialNumber(materialNumBean);
    }

    @Override
    public boolean deleteMaterialById(MaterialUserBean bean) {
        if (materialRepository.existsById(bean.getMaterialId())) {
            materialRepository.deleteById(bean.getMaterialId());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMaterialByUserId(Integer materialId) {
        if (materialRepository.existsByUserId(materialId)) {
            materialRepository.deleteByUserId(materialId);
            return true;
        }
        return false;
    }
}
