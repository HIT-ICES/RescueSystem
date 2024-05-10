package com.hitices.rescuer.controller;

import com.hitices.common.MResponse;
import com.hitices.rescuer.bean.IdBean;
import com.hitices.rescuer.bean.RescuerBean;
import com.hitices.rescuer.entity.Rescuer;
import com.hitices.rescuer.service.RescuerService;
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
 * @date 2021/11/2 9:56
 * @desc
 */
@RestController
@RequestMapping("/rescuer")
public class RescuerController {
    @Resource
    private RescuerService rescuerService;

    @PostMapping("/add")
    @ApiOperation("新增救援人员信息")
    public MResponse add(@RequestBody RescuerBean bean) {
        if (bean == null || bean.getName() == null || bean.getName().length() == 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        Rescuer rescuer = new Rescuer(
                bean.getName(),
                bean.getType() == null ? "normal" : bean.getType(),
                bean.getDesc(),
                bean.getStatus() == null ? "normal" : bean.getStatus()
        );
        try {
            rescuer = rescuerService.insertOrUpdate(rescuer);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e);
        }

        return MResponse.successMResponse().set("data", rescuer);
    }

    @PostMapping ("/getById")
    @ApiOperation("通过ID查找救援人员信息")
    public MResponse getById(@RequestBody IdBean bean) {
        if (bean == null || bean.getId() == null || bean.getId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }

        try {
            Optional<Rescuer> rescuer = rescuerService.select(bean.getId());
            if (rescuer.isPresent()) {
                return MResponse.successMResponse().set("data", rescuer.get());
            }
            return MResponse.failedMResponse().set("message", "未找到此救援人员");
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e);
        }
    }

    @PostMapping("/getAll")
    @ApiOperation("获取所有救援人员信息")
    public MResponse getAll() {
        List<Rescuer> rescuerList = rescuerService.selectAll();
        return MResponse.successMResponse().set("data", rescuerList);
    }

    @PostMapping("/update")
    @ApiOperation("修改救援人员信息")
    MResponse update(@RequestBody Rescuer rescuer) {
        if (rescuer == null || rescuer.getId() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            rescuerService.insertOrUpdate(rescuer);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
        return MResponse.successMResponse();
    }

    @PostMapping("/delete")
    @ApiOperation("删除救援人员信息")
    MResponse delete(@RequestBody IdBean bean) {
        if (bean == null || bean.getId() == null || bean.getId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            rescuerService.deleteById(bean.getId());
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
        return MResponse.successMResponse();
    }
}
