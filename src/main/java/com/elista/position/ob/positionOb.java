package com.elista.position.ob;

import com.elista.base.ob.BaseOB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Thrundi on 2016-05-03.
 */

@Entity
@Table(name = "positions")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_POSITION_ID")
public class PositionOB extends BaseOB implements Serializable{

    private String name;
    @Column(unique = true)
    private String code;
    private String division;

    public PositionOB() {
    }

    public PositionOB(String name, String code, String division) {
        this.name = name;
        this.code = code;
        this.division = division;
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
