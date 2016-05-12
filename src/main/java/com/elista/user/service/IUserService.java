package com.elista.user.service;

import com.elista.user.ob.UserOB;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public interface IUserService {
    UserOB saveUser (UserOB aUserOB);
    Boolean deleteUser (Long aId);
}
