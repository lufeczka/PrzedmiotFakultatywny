package com.elista.base.ob;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Thru on 2016-05-03.
 */
@MappedSuperclass
@SequenceGenerator(allocationSize = 1, name="SEQ", sequenceName="GEN_BASE_ID")
public abstract class baseOB implements Serializable{
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private long id;

    @Column(name="ins_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private DateTime ins_date;

    @Column(name="edi_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private DateTime edi_date;

    public baseOB() {
    }

    public DateTime getEdi_date() {
        return edi_date;
    }

    public DateTime getIns_date() {
        return ins_date;
    }
}
