package com.elista.base.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thrundi on 2016-05-03.
 */
public abstract class BaseDTO implements Serializable{
    private Long id;
    private Date ins_date;
    private Date edi_date;

    public BaseDTO() {
    }

    public BaseDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getIns_date() {
        return ins_date;
    }

    public Date getEdi_date() {
        return edi_date;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
