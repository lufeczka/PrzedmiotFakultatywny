package com.elista.user.service;

import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public interface IUserService {
    UserOB saveUser (UserOB aUserOB);
    Boolean deleteUser (Long aId);
    UserOB updateUser (Long aId, String aEmail, String aName, String aSurname, String aPhoneNumber, String aAddress, DateTime aActiveUntil);
    Boolean updateUserPassword (Long aId, String oldPassword, String newPassword);
}
