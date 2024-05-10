package com.hitices.basicmaterial.controller;

import com.hitices.basicmaterial.bean.RecordIdBean;
import com.hitices.basicmaterial.bean.RecordOptBean;
import com.hitices.basicmaterial.bean.RecordOptDateBean;
import com.hitices.basicmaterial.entity.MaterialRecord;
import com.hitices.basicmaterial.service.MaterialRecordService;
import com.hitices.common.MResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/22 10:13
 */
@RestController
@RequestMapping("/materialRecord")
public class MaterialRecordController {

    @Resource
    private MaterialRecordService recordService;

    @PostMapping("/getByRecordId")
    @ApiOperation(value = "按id获取物资发放记录", httpMethod = "POST")
    public MResponse getByRecordId(@RequestBody RecordIdBean bean) {
        if (bean == null || bean.getRecordId() == null || bean.getRecordId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            Optional<MaterialRecord> record = recordService.getByRecordId(bean.getRecordId());
            if (record.isPresent()) {
                return MResponse.successMResponse().set("data", record.get());
            }
            return MResponse.failedMResponse().set("message", "未找到拥有此id的记录");
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/getAllByOptUserId")
    @ApiOperation(value = "按照操作者获取全部物资发放记录", httpMethod = "POST")
    public MResponse getAllRecordsByOptUserId(@RequestBody RecordOptBean bean) {
        if (bean == null || bean.getUserId() == null || bean.getUserId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            List<MaterialRecord> records = recordService.getAllRecordsByOptUserId(bean.getUserId());
            return MResponse.successMResponse().set("data", records);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/getAllByOptUserIdAndDate")
    @ApiOperation(value = "按照操作者和时间获取全部物资发放记录", httpMethod = "POST")
    public MResponse getAllRecordsByOptUserIdAndDate(@RequestBody RecordOptDateBean bean) {
        if (bean == null || bean.getUserId() == null || bean.getUserId() <= 0 || bean.getStart() == null || bean.getEnd() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            List<MaterialRecord> records = recordService.getAllRecordsByOptUserIdBetween(bean.getUserId(), bean.getStart(), bean.getEnd());
            return MResponse.successMResponse().set("data", records);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "按照id删除物资发放记录", httpMethod = "POST")
    public MResponse deleteById(@RequestBody RecordIdBean bean) {
        if (bean == null || bean.getRecordId() == null || bean.getRecordId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            boolean result = recordService.deleteRecord(bean.getRecordId());
            if (result) {
                return MResponse.successMResponse();
            }
            return MResponse.failedMResponse().set("message", "未找到拥有此id的记录");
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }

    @PostMapping("/deleteByOptUserId")
    @ApiOperation(value = "按照操作者获取删除全部物资发放记录", httpMethod = "POST")
    public MResponse deleteByOptUserId(@RequestBody RecordOptBean bean) {
        if (bean == null || bean.getUserId() == null || bean.getUserId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            recordService.deleteAllRecordsByOptUserId(bean.getUserId());
            return MResponse.successMResponse();
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
    }
}
