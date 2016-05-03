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
    //List<UserDTO> findAll();
    List<UserDTO> findByNameStartsWith(String name);
    List<UserDTO> findBySurnameStartsWith(String surname);
    List<UserDTO> findByNameStartsWithOrSurnameStartsWith(String name, String surname);
    List<UserDTO> findByNameEqualsAndSurnameEquals(String name, String surname);
    List<UserDTO> findByActiveUntilBetween(DateTime activeUntil, DateTime activeUntil2);
    List<UserDTO> findByEmailStartsWith(String email);
    List<UserDTO> findByEmailEquals(String email);
    @Query("SELECT u FROM UserOB u WHERE u.id = ?1")
    List<UserDTO> findByIdEquals(Long id);
}
