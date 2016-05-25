package com.elista.user.api;

import com.elista.position.ob.positionOb;
import com.elista.user.ob.UserOB;
import com.elista.user.repository.IUserRepository;
import com.elista.user.service.IUserService;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import org.apache.catalina.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    IUserRepository iUserRepository;

    @RequestMapping(value = "updateUserPassword", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> updateUserPassword(@RequestParam("user_id") Long user_id, @RequestParam("old_password") String old_password, @RequestParam("new_password") String new_password){
        try {
            return new ResponseEntity<Boolean>(iUserService.updateUserPassword(user_id, old_password, new_password), HttpStatus.OK);
        } catch (Exception e)
        {
            return  new ResponseEntity<Boolean>(false, HttpStatus.NOT_MODIFIED);
        }
    }


    @RequestMapping(value = "addUser", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserOB> addUser(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("address") String address, @RequestParam("phone_number") String phone_number) {
        try{
            UserOB user = new UserOB(email, password, name, surname, phone_number, address, DateTime.now().withTimeAtStartOfDay());
            iUserRepository.save(user);
            return new ResponseEntity<UserOB>(user, HttpStatus.OK);
        } catch (Exception e)
        {
            return  new ResponseEntity<UserOB>(HttpStatus.NOT_MODIFIED);
        }
    }

    /*

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

    */
}
