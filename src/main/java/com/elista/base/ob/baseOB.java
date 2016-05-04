package com.elista.base.ob;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thrundi on 2016-05-03.
 */
@MappedSuperclass
@SequenceGenerator(allocationSize = 1, name="SEQ", sequenceName="GEN_BASE_ID")
public abstract class BaseOB implements Serializable{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    @Column(name="ins_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ins_date;

    @Column(name="edi_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date edi_date;

    public BaseOB() {
    }

    public Long getId() {
        return id;
    }

    public Date getEdi_date() {
        return edi_date;
    }

    public Date getIns_date() {
        return ins_date;
    }
}
