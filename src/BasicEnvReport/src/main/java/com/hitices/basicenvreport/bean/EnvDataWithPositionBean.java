package com.hitices.basicenvreport.bean;

import com.hitices.common.sensor.data.Environment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvDataWithPositionBean extends Environment {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEnvironment(Environment environment){
        this.setHd(environment.getHd());
        this.setTp(environment.getTp());
        this.setTimestamp(environment.getTimestamp());
        this.setType(environment.getType());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
