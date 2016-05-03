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

    /*
    @Override
    public List<UserDTO> findAll() {
        return UserConverter.UserOBToDTO(iUserRepository.findAll());
    }
    */

    @Override
    public List<UserDTO> findByNameStartsWith(String name) {
        return UserConverter.UserOBToDTO(iUserRepository.findByNameStartsWith(name));
    }

    @Override
    public List<UserDTO> findBySurnameStartsWith(String surname) {
        return UserConverter.UserOBToDTO(iUserRepository.findBySurnameStartsWith(surname));
    }

    @Override
    public List<UserDTO> findByNameStartsWithOrSurnameStartsWith(String name, String surname) {
        return UserConverter.UserOBToDTO(iUserRepository.findByNameStartsWithOrSurnameStartsWith(name, surname));
    }

    @Override
    public List<UserDTO> findByNameEqualsAndSurnameEquals(String name, String surname) {
        return UserConverter.UserOBToDTO(iUserRepository.findByNameEqualsAndSurnameEquals(name, surname));
    }

    @Override
    public List<UserDTO> findByActiveUntilBetween(DateTime activeUntil, DateTime activeUntil2) {
        return UserConverter.UserOBToDTO(iUserRepository.findByActiveUntilBetween(activeUntil, activeUntil2));
    }

    @Override
    public List<UserDTO> findByEmailStartsWith(String email) {
        return UserConverter.UserOBToDTO(iUserRepository.findByEmailStartsWith(email));
    }

    @Override
    public List<UserDTO> findByEmailEquals(String email) {
        return UserConverter.UserOBToDTO(iUserRepository.findByEmailEquals(email));
    }

    @Override
    public List<UserDTO> findByIdEquals(Long id) {
        return UserConverter.UserOBToDTO(iUserRepository.findByIdEquals(id));
    }


}
