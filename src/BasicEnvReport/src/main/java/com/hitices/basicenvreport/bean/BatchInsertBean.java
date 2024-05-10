package com.hitices.basicenvreport.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchInsertBean
{
    private String[][] data;
    private String schemaId;
}
