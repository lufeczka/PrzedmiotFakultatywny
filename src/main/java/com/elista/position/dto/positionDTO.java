package com.elista.position.dto;


import com.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Thrundi on 2016-05-03.
 */
@ApiModel
public class positionDTO extends BaseDTO implements Serializable {
    private String name;
    private String code;
    private String division;


    public positionDTO() {
    }

    public positionDTO(String division, String name, String code) {
        this.division = division;
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
