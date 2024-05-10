package com.hitices.basicmaterial.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/22 10:24
 */
@Getter
@Setter
@NoArgsConstructor
public class RecordOptDateBean {
    private Integer userId;
    private Date start;
    private Date end;
}
