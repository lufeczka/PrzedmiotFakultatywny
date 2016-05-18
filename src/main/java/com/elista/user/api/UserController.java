package com.elista.user.api;

import com.elista.user.service.IUserService;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

/**
 * Created by Thrundi on 2016-05-03.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    IUserService iUserService;


    @RequestMapping(value = "updateUserPassword/{user_id}/{old_password}/{new_password}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> updateUserPassword(@PathVariable("user_id") Long user_id, @PathVariable("old_password") String old_password, @PathVariable("new_password") String new_password){
        try {
            return new ResponseEntity<Boolean>(iUserService.updateUserPassword(user_id, old_password, new_password), HttpStatus.OK);
        } catch (Exception e)
        {
            return  new ResponseEntity<Boolean>(false, HttpStatus.NOT_MODIFIED);
        }
    }
}
