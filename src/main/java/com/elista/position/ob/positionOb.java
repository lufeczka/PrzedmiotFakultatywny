package com.elista.position.ob;

import com.elista.base.ob.baseOB;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Thrundi on 2016-05-03.
 */

@Entity
@Table(name = "positions")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_POSITIONS_ID")
public class positionOb extends baseOB implements Serializable{

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String code;
    private String division;

    public positionOb() {
    }

    public positionOb(String name, String code, String division) {
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
