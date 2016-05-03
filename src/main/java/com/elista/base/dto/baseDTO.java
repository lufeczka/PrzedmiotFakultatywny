package com.elista.base.dto;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by Thrundi on 2016-05-03.
 */
public abstract class BaseDTO implements Serializable{
    private long id;
    private DateTime ins_date;
    private DateTime edi_date;

    public BaseDTO() {
    }

    public BaseDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public DateTime getIns_date() {
        return ins_date;
    }

    public DateTime getEdi_date() {
        return edi_date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
