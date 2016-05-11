package com.elista.user.service;

import com.elista.functions.converters.UserConverter;
import com.elista.user.dto.UserDTO;
import com.elista.user.ob.UserOB;
import com.elista.user.repository.IUserRepository;
import org.apache.catalina.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
}
