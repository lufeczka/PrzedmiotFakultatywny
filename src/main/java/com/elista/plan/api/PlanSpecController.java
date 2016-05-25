package com.elista.plan.api;

import com.elista.functions.exceptions.NullException;
import com.elista.plan.ob.PlanOB;
import com.elista.plan.ob.PlanSpecOB;
import com.elista.plan.repository.IPlanRepository;
import com.elista.plan.repository.IPlanSpecRepository;
import com.elista.plan.service.IPlanService;
import com.elista.position.ob.positionOb;
import com.elista.position.repository.IPositionRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.developer.Serialization;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

/**
 * Created by Thrundi on 2016-05-25.
 */

@RestController
@RequestMapping(value = "/plans_spec")
public class PlanSpecController {

    @Autowired
    IPlanRepository iPlanRepository;

    @Autowired
    IPlanSpecRepository iPlanSpecRepository;

    @RequestMapping(value = "addPlanSpec", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlanSpecOB> addPlanSpec(@RequestParam("plan_id") Long plan_id, @RequestParam("day_of_week") Short day_of_week, @RequestParam("time_from")Time time_from, @RequestParam("time_to")Time time_to){
        try{
            PlanOB plan = iPlanRepository.findOne(plan_id);
            if (plan == null)
                return new ResponseEntity<PlanSpecOB>(HttpStatus.NOT_MODIFIED);

            PlanSpecOB plan_spec = new PlanSpecOB(plan, day_of_week, time_from, time_to);
            iPlanSpecRepository.save(plan_spec);
            return new ResponseEntity<PlanSpecOB>(plan_spec, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<PlanSpecOB>(HttpStatus.NOT_MODIFIED);
        }
    }
}