package com.elista.plan.api;

import com.elista.functions.exceptions.NullException;
import com.elista.plan.ob.PlanOB;
import com.elista.plan.repository.IPlanRepository;
import com.elista.plan.service.IPlanService;
import com.elista.position.ob.positionOb;
import com.elista.position.repository.IPositionRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Thrundi on 2016-05-12.
 */

@RestController
@RequestMapping(value = "/plans")
public class PlanController {


    @Autowired
    IPlanRepository iPlanRepository;

    @Autowired
    IPlanService iPlanService;

    @Autowired
    IPositionRepository iPositionRepository;

    @RequestMapping(value = "addPlan", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Long> savePlan(@RequestBody PlanOB planOB) {
        try {
            return new ResponseEntity<Long>(iPlanService.savePlan(planOB), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Long>((long) -1, HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "getPlanById", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlanOB> getPlan(@RequestParam("id") Long planId){
        try {
            return new ResponseEntity<PlanOB>(iPlanService.getPlan(planId), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<PlanOB>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "addPlan", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlanOB> addPlan(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("position_id") Long position_id)
    {
        try{
            positionOb position = iPositionRepository.findOne(position_id);
            if (position == null)
                return new ResponseEntity<PlanOB>(HttpStatus.NOT_MODIFIED);
            PlanOB plan = new PlanOB(position, code, name);
            iPlanRepository.save(plan);
            return new ResponseEntity<PlanOB>(plan, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PlanOB>(HttpStatus.NOT_MODIFIED);
        }
    }
}
