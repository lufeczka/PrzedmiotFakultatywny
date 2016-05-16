package com.elista.plan.service;

import com.elista.functions.exceptions.NullException;
import com.elista.plan.ob.PlanOB;
import org.jvnet.hk2.annotations.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thrundi on 2016-05-12.
 */
@Service
@Transactional
public interface IPlanService {
    long savePlan(PlanOB planOB) throws NullException;
    PlanOB getPlan(Long planId);
}