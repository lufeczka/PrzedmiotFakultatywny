package com.elista.user.service;

import com.elista.user.ob.UserOB;
import com.elista.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserOB createUser(UserOB user) {
        UserOB userOB = user;
        return userOB;
    }

}
