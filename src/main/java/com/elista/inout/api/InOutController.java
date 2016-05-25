package com.elista.inout.api;

import com.elista.inout.ob.InOutOB;
import com.elista.inout.repository.IInOutRepository;
import com.elista.inout.service.IInOutService;
import com.elista.user.ob.UserOB;
import com.elista.user.repository.IUserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-16.
 */

@RestController
@RequestMapping(value = "/inouts")
public class InOutController {

    @Autowired
    IInOutService iInOutService;

    @Autowired
    IInOutRepository iInOutRepository;

    @Autowired
    IUserRepository iUserRepository;

    @RequestMapping(value = "inout", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> InOut(@RequestParam("user_id") Long user_id){
        try{
            return new ResponseEntity<String> (iInOutService.inOut(user_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "userTimeToday", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Long> userTimes(@RequestParam("user_id") Long user_id)
    {
        try {
            UserOB user = iUserRepository.findOne(user_id);
            if (user == null)
                return new ResponseEntity<Long>(HttpStatus.NOT_MODIFIED);

            List<InOutOB> inouts = iInOutRepository.findByUserAndDateFromGreaterThan(user, DateTime.now().withTimeAtStartOfDay());
            Long sum = Long.valueOf(0);

            for (InOutOB inout : inouts) {
                Long dateTo;
                if (inout.getDateTo() == null)
                    dateTo = DateTime.now().getMillis();
                else
                    dateTo = inout.getDateTo().getMillis();

                sum += dateTo - inout.getDateFrom().getMillis();
            }

            return new ResponseEntity<Long>(sum, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Long>(HttpStatus.NOT_MODIFIED);
        }
    }

}
