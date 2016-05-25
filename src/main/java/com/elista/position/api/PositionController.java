package com.elista.position.api;

import com.elista.plan.ob.PlanOB;
import com.elista.plan.repository.IPlanRepository;
import com.elista.plan.service.IPlanService;
import com.elista.position.ob.positionOb;
import com.elista.position.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-25.
 */

@RestController
@RequestMapping(value = "/positions")
public class PositionController {


    @Autowired
    IPlanRepository iPlanRepository;

    @Autowired
    IPlanService iPlanService;

    @Autowired
    IPositionRepository iPositionRepository;


    @RequestMapping(value = "addPosition", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<positionOb> addPlan(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("division") String division)
    {
        try{
            List<positionOb> positions = iPositionRepository.findByCodeEquals(code);
            if (positions.size() > 0)
                return new ResponseEntity<positionOb>(HttpStatus.NOT_MODIFIED);

            positions = iPositionRepository.findByDivisionEqualsAndNameEquals(division, name);
            if (positions.size() > 0)
                return new ResponseEntity<positionOb>(HttpStatus.NOT_MODIFIED);

            positionOb position = new positionOb(name, code, division);
            iPositionRepository.save(position);
            return new ResponseEntity<positionOb>(position, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<positionOb>(HttpStatus.NOT_MODIFIED);
        }
    }

}
