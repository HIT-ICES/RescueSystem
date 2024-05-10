package com.hitices.rescuer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitices.common.MResponse;
import com.hitices.rescuer.bean.*;
import com.hitices.rescuer.entity.RescuerStatus;
import com.hitices.rescuer.service.RescuerStatusService;
import com.hitices.rescuer.service.frignService.RescuerInfoManageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/11/2 9:56
 * @desc
 */
@RestController
@Api(value = "Hello Controller")
@RequestMapping("/rescuerStatus")
public class RescuerController {
    @Resource
    private RescuerStatusService rescuerStatusService;

    @Resource
    private RescuerInfoManageService infoManageService;

    @PostMapping("/add")
    @ApiOperation("新增救援人员状态信息（救援人员上报）")
    public MResponse add(@RequestBody RescuerStatusBean bean) {
        if (bean == null || bean.getStatus() == null || bean.getRescuerId() == null || bean.getLocation() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        RescuerStatus rescuerStatus = new RescuerStatus(
                bean.getStatus(),
                bean.getDesc(),
                bean.getLocation(),
                bean.getRescuerId()
        );
        rescuerStatus = rescuerStatusService.insert(rescuerStatus);

        // update rescuerStatus
        MResponse response = infoManageService.selectById(new IdBean(bean.getRescuerId()));

        if (response.getCode() != 0) {
            return MResponse.failedMResponse().set("message", "调用救援人员信息管理服务查询信息接口失败").set("data", response);
        }
        String message = "救援人员状态保持不变！";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Rescuer rescuer = objectMapper.convertValue(response.getValueMap().get("data"), Rescuer.class);
            // 状态发生了变化，更新人员状态
            if (!rescuer.getStatus().equals(bean.getStatus())) {
                rescuer.setStatus(bean.getStatus());
                MResponse temp = infoManageService.updateStatus(rescuer);
                if (temp.getCode() != 0) {
                    return MResponse.failedMResponse().set("message", "调用救援人员信息管理服务更新信息接口失败！").set("data", temp);
                }
                message = "救援人员状态已更改！";
            }
            return MResponse.successMResponse().set("data", rescuerStatus).set("message", message);
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e);
        }
    }

    @PostMapping("/getAllByRescuerId")
    @ApiOperation("通过救援人员Id获取所有救援人员状态信息")
    public MResponse getAllByRescuerId(@RequestBody RescuerIdBean rescuerIdBean) {
        if (rescuerIdBean == null || rescuerIdBean.getRescuerId() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        List<RescuerStatus> rescuerList = rescuerStatusService.selectByRescuerId(rescuerIdBean.getRescuerId());
        return MResponse.successMResponse().set("data", rescuerList);
    }

    @PostMapping("/getAllByRescuerIdBetweenDate")
    @ApiOperation("通过ID与时间查找救援人员状态信息")
    public MResponse getAllByRescuerIdBetweenDate(@RequestBody RescuerStatusDateBean bean) {
        if (bean == null || bean.getRescuerId() == null || bean.getEnd() == null || bean.getStart() == null) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        List<RescuerStatus> rescuerList = rescuerStatusService.selectByRescuerIdBetweenDate(bean.getRescuerId(), bean.getStart(), bean.getEnd());
        return MResponse.successMResponse().set("data", rescuerList);
    }

    @PostMapping("/deleteByRescuerId")
    @ApiOperation("通过救援人员ID删除救援人员状态信息")
    MResponse delete(@RequestBody RescuerIdBean bean) {
        if (bean == null || bean.getRescuerId() == null || bean.getRescuerId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            rescuerStatusService.deleteByRescuerId(bean.getRescuerId());
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
        return MResponse.successMResponse();
    }

    @PostMapping("/deleteById")
    @ApiOperation("删除救援人员状态信息")
    MResponse delete(@RequestBody IdBean bean) {
        if (bean == null || bean.getId() == null || bean.getId() <= 0) {
            return MResponse.failedMResponse().set("message", "请求参数不合法！");
        }
        try {
            rescuerStatusService.deleteById(bean.getId());
        } catch (Exception e) {
            return MResponse.failedMResponse().set("message", e.getMessage());
        }
        return MResponse.successMResponse();
    }
}
