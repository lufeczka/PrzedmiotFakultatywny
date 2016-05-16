package com.elista.plan.api;

import com.elista.plan.ob.PlanOB;
import com.elista.plan.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

/**
 * Created by Thrundi on 2016-05-12.
 */

@RestController
@RequestMapping(value = "/plans")
public class PlanController {

//    @Autowired
    IPlanService iPlanService;

    @RequestMapping(value = "/addPlan", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Long> savePlan(@RequestBody PlanOB planOB) {
        try {
            return new ResponseEntity<Long>(iPlanService.savePlan(planOB), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Long>((long) -1, HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/getPlanById?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PlanOB> getPlan(@Param("id") long planId){
        //try {
            return new ResponseEntity<PlanOB>(iPlanService.getPlan(planId), HttpStatus.OK);
        /*
        }catch (Exception e)
        {
            return new ResponseEntity<PlanOB>(null, HttpStatus.NOT_FOUND);
        }
    */
    }
}
