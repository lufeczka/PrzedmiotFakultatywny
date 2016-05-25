package com.elista.inout.api;

import com.elista.inout.service.IInOutService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Thrundi on 2016-05-16.
 */

@RestController
@RequestMapping(value = "/inouts")
public class InOutController {

    @Autowired
    IInOutService iInOutService;

    @RequestMapping(value = "inout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> InOut(@RequestParam("user_id") Long user_id){
        try{
            return new ResponseEntity<String> (iInOutService.inOut(user_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

//    @RequestMapping(value = "userTimes{user_id}", method = RequestMethod.GET)
//    @RequestBody
//    public ResponseEntity<DateTime> InOut(@PathVariable("user_id") Long)
}
