package com.elista.plan.api;

import com.elista.functions.exceptions.NullException;
import com.elista.plan.ob.PlanOB;
import com.elista.plan.service.IPlanService;
import com.elista.position.ob.positionOb;
import com.elista.position.repository.IPositionRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
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

    @RequestMapping(value = "getPlanById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlanOB> getPlan(@PathVariable("id") Long planId){
        try {
            return new ResponseEntity<PlanOB>(iPlanService.getPlan(planId), HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<PlanOB>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "addPlan/{code}/{name}/{position_id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PlanOB> addPlan(@PathVariable("code") String code, @PathVariable("name") String name, @PathVariable("position_id") Long position_id)
    {
        try{
            positionOb position = iPositionRepository.findOne(position_id);
//            if (position == null)
//                throw new NullException("Position not found", HttpStatus.NOT_MODIFIED, new HttpHeaders());
            PlanOB plan = new PlanOB(position, code, name);
            return new ResponseEntity<PlanOB>(plan, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PlanOB>(HttpStatus.OK);
        }
    }


}
