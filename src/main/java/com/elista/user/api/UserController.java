package com.elista.user.api;

import com.elista.user.dto.UserDTO;
import com.elista.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<List<UserDTO>>(iUserService.getAllUsers(), HttpStatus.OK);
    }
}
