package com.elista.inout.ob;

import com.elista.base.ob.baseOB;
import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Thrundi on 2016-05-11.
 */


@Entity
@Table(name = "inouts")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_INOUTS_ID")
public class InOutOB extends baseOB {

    @Column(unique = true)
    private DateTime dateFrom;
    private DateTime dateTo;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private UserOB user;
}
