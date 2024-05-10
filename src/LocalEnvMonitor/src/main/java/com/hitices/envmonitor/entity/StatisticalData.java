package com.hitices.envmonitor.entity;

import com.hitices.envmonitor.bean.DatumBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 15:12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticalData {
    private Integer num;
    private List<DatumBean> data;
}
