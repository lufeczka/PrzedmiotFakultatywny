package com.elista.plan.ob;

import com.elista.base.ob.baseOB;
import com.elista.position.ob.positionOb;
import com.elista.user.ob.UserOB;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-04.
 */

@Entity
@Table(name = "plans")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PLANS_ID")
public class PlanOB extends baseOB {

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String code;

    @ManyToMany()
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private List<UserOB> users;

    @ManyToOne()
    private positionOb position;

    public PlanOB() {
    }

    public PlanOB(String name, String code, List<UserOB> users, positionOb position) {
        this.name = name;
        this.code = code;
        this.users = users;
        this.position = position;
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

    public List<UserOB> getUsers() {
        return users;
    }

    public void setUsers(List<UserOB> users) {
        this.users = users;
    }

    public positionOb getPosition() {
        return position;
    }

    public void setPosition(positionOb position) {
        this.position = position;
    }
}
