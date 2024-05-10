package com.hitices.basicenvreport.client;

import com.hitices.common.MResponse;
import com.hitices.basicenvreport.bean.BatchInsertBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author teng
 * 向异构环境数据收集服务上传数据
 */
@FeignClient(name = "BasicEnvironmentStatistics", url = "http://basicenvironmentstatistics:8080")
public interface BasicEnvironmentStatisticsClient {
    @RequestMapping(value = "/statistic/data/insert", method = RequestMethod.POST)
    MResponse insert(BatchInsertBean batchInsertBean);
}
