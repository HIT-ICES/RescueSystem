package com.hitices.envmonitor.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/10/24 14:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatumBean
{
    private String id;
    private String schemaId;
    private String[] values;
}

