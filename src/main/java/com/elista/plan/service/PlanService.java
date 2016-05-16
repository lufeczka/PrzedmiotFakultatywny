package com.elista.plan.service;

import com.elista.functions.exceptions.NullException;
import com.elista.plan.ob.PlanOB;
import com.elista.plan.repository.IPlanRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;

/**
 * Created by Thrundi on 2016-05-12.
 */
@Service
@Transactional
public class PlanService implements IPlanService {

    @Autowired
    IPlanRepository iPlanRepository;

    public PlanService() {
    }

    @Override
    public long savePlan(PlanOB planOB) throws NullException {

        if (planOB == null)
            throw new NullException("Parameter invalid", HttpStatus.NOT_FOUND, new HttpHeaders());

        iPlanRepository.save(planOB);
        return planOB.getId();
    }

    @Override
    public PlanOB getPlan(Long planId){
        return iPlanRepository.findOne(planId);
    }
}
