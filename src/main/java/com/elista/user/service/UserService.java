package com.elista.user.service;

import com.elista.user.ob.UserOB;
import com.elista.user.repository.IUserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserOB saveUser(UserOB aUserOB) {
        iUserRepository.save(aUserOB);
        return iUserRepository.findOne(aUserOB.getId());
    }

    @Override
    public Boolean deleteUser(Long aId) {
        if (iUserRepository.findOne(aId) == null) return false;
        iUserRepository.delete(aId);
        if (iUserRepository.findOne(aId) == null) return true;
        return false;
    }

    @Override
    public UserOB updateUser(Long aId, String aEmail, String aName, String aSurname, String aPhoneNumber, String aAddress, DateTime aActiveUntil) {
        UserOB user = iUserRepository.findOne(aId);
        user.setEmail(aEmail);
        user.setName(aName);
        user.setSurname(aSurname);
        user.setPhoneNumber(aPhoneNumber);
        user.setAddress(aAddress);
        user.setActiveUntil(aActiveUntil);
        iUserRepository.save(user);
        return user;
    }

    @Override
    public Boolean updateUserPassword(Long aId, String oldPassword, String newPassword) {
        UserOB user = iUserRepository.findOne(aId);
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            iUserRepository.save(user);
            return true;
        }
        return false;
    }
}
