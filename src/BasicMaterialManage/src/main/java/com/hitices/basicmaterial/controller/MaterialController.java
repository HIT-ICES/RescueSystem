package com.hitices.basicmaterial.controller;

import com.hitices.basicmaterial.bean.MaterialBean;
import com.hitices.basicmaterial.bean.MaterialNumBean;
import com.hitices.basicmaterial.bean.MaterialUserBean;
import com.hitices.basicmaterial.bean.RecordBean;
import com.hitices.basicmaterial.entity.Material;
import com.hitices.basicmaterial.entity.MaterialRecord;
import com.hitices.basicmaterial.service.MaterialRecordService;
import com.hitices.basicmaterial.service.MaterialService;

import com.hitices.common.MResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 21:21
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Resource
    private MaterialService materialService;

    @Resource
    private MaterialRecordService recordService;

    @PostMapping("/getAll")
    @ApiOperation(value = "获取全部物资数据", httpMethod = "POST")
    public MResponse getAllMaterial() {
        MResponse response = MResponse.successMResponse();
        response.set("data", materialService.getAllMaterials());
        return response;
    }

    @PostMapping("/getById")
    @ApiOperation(value = "按照ID获取物资数据", httpMethod = "POST")
    public MResponse getMaterialById(@RequestBody MaterialUserBean bean) {
        if (bean == null || bean.getMaterialId() == null || bean.getUserId() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            Optional<Material> materialOptional = materialService.getMaterialById(bean);
            if (materialOptional.isPresent()) {
                return MResponse.successMResponse().set("data", materialOptional.get());
            }
            return MResponse.failedMResponse().set("message", "未找到此物资");
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加物资", httpMethod = "POST")
    public MResponse addMaterial(@RequestBody MaterialBean materialBean) {
        if (materialBean == null || materialBean.getName() == null || materialBean.getUserId() == null || materialBean.getNumber() == null || materialBean.getNumber() < 0L) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            Integer id = materialService.addMaterial(materialBean);
            // add opt record
            RecordBean record = new RecordBean(
                    id,
                    "add",
                    null,
                    materialBean.getUserId()
            );
            recordService.addRecord(record);
            return MResponse.successMResponse().set("materialId", id);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/put")
    @ApiOperation(value = "发放物资", httpMethod = "POST")
    public MResponse putMaterial(@RequestBody MaterialNumBean bean) {
        if (bean == null || bean.getMaterialId() == null || bean.getNumber() == null || bean.getUserId() == null || bean.getNumber() <= 0L) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            boolean result = materialService.putMaterial(bean);
            if (!result) {
                return MResponse.failedMResponse().set("message", "添加失败");
            } else {
                // add opt record
                RecordBean record = new RecordBean(
                        bean.getMaterialId(),
                        "put",
                        bean.getNumber(),
                        bean.getUserId()
                );
                recordService.addRecord(record);
                return MResponse.successMResponse();
            }
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/take")
    @ApiOperation(value = "提取物资", httpMethod = "POST")
    public MResponse takeMaterial(@RequestBody MaterialNumBean bean) {
        if (bean == null || bean.getMaterialId() == null || bean.getNumber() == null || bean.getUserId() == null || bean.getNumber() <= 0L) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            boolean result = materialService.takeMaterial(bean);
            if (!result) {
                return MResponse.failedMResponse().set("message", "物资库存不足");
            } else {
                // add opt record
                RecordBean record = new RecordBean(
                        bean.getMaterialId(),
                        "take",
                        -bean.getNumber(),
                        bean.getUserId()
                );
                recordService.addRecord(record);
                return MResponse.successMResponse();
            }
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "按id删除物资", httpMethod = "POST")
    public MResponse deleteMaterialById(@RequestBody MaterialUserBean bean) {
        if (bean == null || bean.getMaterialId() == null || bean.getUserId() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            boolean result = materialService.deleteMaterialById(bean);
            if (!result) {
                return MResponse.failedMResponse().set("message", "此编号物资不存在");
            } else {
                // add opt record
                RecordBean record = new RecordBean(
                        bean.getMaterialId(),
                        "delete",
                        null,
                        bean.getUserId()
                );
                recordService.addRecord(record);
                return MResponse.successMResponse();
            }
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }
}
