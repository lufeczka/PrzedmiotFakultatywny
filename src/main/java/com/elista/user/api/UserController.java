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
/*
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAll(){
        return new ResponseEntity<List<UserDTO>>(iUserService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "findByNameStartsWith/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findByNameStartsWith(@PathVariable("name")String name) {
        return new ResponseEntity<List<UserDTO>>(iUserService.findByNameStartsWith(name), HttpStatus.OK);
    }

    @RequestMapping(value = "findByEmailStartsWith/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findByEmailStartsWith(@PathVariable("email")String email) {
        return new ResponseEntity<List<UserDTO>>(iUserService.findByEmailStartsWith(email), HttpStatus.OK);
    }

    @RequestMapping(value = "findByNameStartsWithOrSurnameStartsWith/{nameorsurname}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findByNameStartsWithOrSurnameStartsWith(@PathVariable("nameorsurname")String nameorsurname) {
        return new ResponseEntity<List<UserDTO>>(iUserService.findByNameStartsWithOrSurnameStartsWith(nameorsurname, nameorsurname), HttpStatus.OK);
    }

    @RequestMapping(value = "findByIdEquals/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findByIdEquals(@PathVariable("id")Long id) {
        return new ResponseEntity<List<UserDTO>>(iUserService.findByIdEquals(id), HttpStatus.OK);
    }
*/ //Nowy sposob wystawiania RESTow, patrz IUserRepository
}
