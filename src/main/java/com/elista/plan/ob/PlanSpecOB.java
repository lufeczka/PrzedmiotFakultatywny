package com.elista.plan.ob;

import com.elista.base.ob.baseOB;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Time;

/**
 * Created by Thrundi on 2016-05-04.
 */
@Entity
@Table(name = "plans_spec")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PLANS_SPEC_ID")
public class PlanSpecOB extends baseOB {
    @OneToOne()
    private PlanOB plan;
    private Short dayOfWeek;
    private Time timeFrom;
    private Time timeTo;

    public PlanSpecOB() {
    }

    public PlanSpecOB(PlanOB plan, Short dayOfWeek, Time timeFrom, Time timeTo) {
        this.plan = plan;
        this.dayOfWeek = dayOfWeek;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public PlanOB getPlan() {
        return plan;
    }

    public void setPlan(PlanOB plan) {
        this.plan = plan;
    }

    public Short getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Short dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }
}
