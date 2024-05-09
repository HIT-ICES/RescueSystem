package com.hitices.environment_statistics.controller;

import com.hitices.common.MResponse;
import com.hitices.environment_statistics.bean.SelectBean;
import com.hitices.environment_statistics.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "Data Controller")
@RequestMapping("/statistic/data")
public class StatisticDataController extends ControllerBase
{
    private final DataService dataService;

    public StatisticDataController(@Qualifier("DataServiceImpl") DataService dataService)
    {
        this.dataService = dataService;
    }


    @PostMapping(value = "/insert")
    @ApiOperation(value = "插入环境数据", httpMethod = "POST")
    public MResponse insert(@RequestBody List<Map<String, String>> data)
    {
        return Ok(dataService.insert(data));
    }

    @PostMapping(value = "/select")
    @ApiOperation(value = "获取环境数据", httpMethod = "POST")
    public MResponse select(@RequestBody SelectBean filter)
    {
        return Ok(dataService.select(filter));
    }
}
