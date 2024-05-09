package com.hitices.environment_statistics.service;

import com.hitices.environment_statistics.bean.SelectBean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public interface DataService
{
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSSSSS");

    String[] insert(List<Map<String, String>> data);

    List<Map<String, String>> select(SelectBean filter);
}
