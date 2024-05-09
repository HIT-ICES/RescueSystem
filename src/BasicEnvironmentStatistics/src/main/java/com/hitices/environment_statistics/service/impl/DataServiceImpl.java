package com.hitices.environment_statistics.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.hitices.environment_statistics.bean.SelectBean;
import com.hitices.environment_statistics.dao.DatumRepository;
import com.hitices.environment_statistics.entity.Datum;
import com.hitices.environment_statistics.service.DataService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Qualifier("DataServiceImpl")
public class DataServiceImpl implements DataService
{
    private final DatumRepository datumRepository;

    public DataServiceImpl(DatumRepository datumRepository)
    {
        this.datumRepository = datumRepository;
    }

    @Override
    public String[] insert(List<Map<String, String>> data)
    {
        return datumRepository.saveAll(data.stream().map((d) ->
        {
            Datum datum = new Datum();
            datum.setType(d.getOrDefault("type", "ANY"));
            String time = d.getOrDefault("timestamp", "");
            if (time.equals(""))
            {
                datum.setUpdateTime(new Date());
            } else
            {

                try
                {
                    datum.setUpdateTime(dateFormatter.parse(time));

                } catch (ParseException e)
                {
                    datum.setUpdateTime(new Date());
                }
            }
            d.remove("timestamp");
            d.remove("type");
            try
            {
                datum.setValue(new ObjectMapper().writeValueAsString(d));
            } catch (JsonProcessingException e)
            {
                e.printStackTrace();
            }
            return datum;
        }).collect(Collectors.toList())).stream().map(Datum::getId).toArray(String[]::new);
    }


    @Override
    public List<Map<String, String>> select(SelectBean filter)
    {

        return datumRepository.findAllByTypeAndUpdateTimeBetween(filter.getType(), filter.getStart(), filter.getEnd()).stream().map(datum ->
        {
            Map<String, String> map = null;
            try
            {
                map = new ObjectMapper().readValue(datum.value, new TypeReference<Map<String, String>>()
                {
                });
                map.put("type", datum.getType());
                map.put("timestamp", dateFormatter.format(datum.getUpdateTime()));

            } catch (JsonProcessingException e)
            {
                e.printStackTrace();
            }
            return map;

        }).collect(Collectors.toList());
    }

}
