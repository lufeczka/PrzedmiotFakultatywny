package com.elista.user.api;

import com.elista.user.dto.UserDTO;
import com.elista.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    IUserService iUserService;

}
