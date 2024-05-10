package com.hitices.basicmaterial.service;

import com.hitices.basicmaterial.bean.MaterialUserBean;
import com.hitices.basicmaterial.entity.Material;
import com.hitices.basicmaterial.bean.MaterialBean;
import com.hitices.basicmaterial.bean.MaterialNumBean;

import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 18:47
 */
public interface MaterialService {
    /**
     * select all materials
     * @return material list
     */
    List<Material> getAllMaterials();

    /**
     * select material by userId and name
     *
     * @param userId userId
     * @return material or null(not find)
     */
    Optional<Material> getMaterialByUserId(Integer userId);

    /**
     * get material by id
     *
     * @param bean
     * @return
     */
    Optional<Material> getMaterialById(MaterialUserBean bean);

    /**
     * insert a material
     * @param materialBean
     */
    Integer addMaterial(MaterialBean materialBean);

    /**
     * insert a list of materials
     *
     * @param materialBean
     */
     List<Integer> addMaterialList(List<MaterialBean> materialBean);

    /**
     * change number of a material
     *
     * @param materialNumBean number > 0: put , number < 0: take
     * @return true: success, false: fail
     */
    boolean changeMaterialNumber(MaterialNumBean materialNumBean);

    /**
     * put material
     *
     * @param materialNumBean
     * @return
     */
    boolean putMaterial(MaterialNumBean materialNumBean);

    /**
     * take material
     *
     * @param materialNumBean
     * @return
     */
    boolean takeMaterial(MaterialNumBean materialNumBean);

    /**
     * delete a material by id
     *
     * @param bean
     * @return true: success, false: fail
     */
    boolean deleteMaterialById(MaterialUserBean bean);

    /**
     * delete a material by user id
     *
     * @param materialId
     * @return
     */
    boolean deleteMaterialByUserId(Integer materialId);
}
