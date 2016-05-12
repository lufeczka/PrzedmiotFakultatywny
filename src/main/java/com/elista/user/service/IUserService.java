package com.elista.user.service;

import com.elista.user.dto.UserDTO;
import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;
import org.jvnet.hk2.annotations.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public interface IUserService {

    UserOB createUser(UserOB user);
}
