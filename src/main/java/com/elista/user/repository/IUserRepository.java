package com.elista.user.repository;

import com.elista.user.dto.UserDTO;
import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public interface IUserRepository extends JpaRepository<UserOB, Long> {
    List<UserOB> findByNameStartsWith(String name);
    List<UserOB> findBySurnameStartsWith(String surname);
    List<UserOB> findByNameStartsWithOrSurnameStartsWith(String name, String surname);
    List<UserOB> findByNameEqualsAndSurnameEquals(String name, String surname);
    List<UserOB> findByActiveUntilBetween(DateTime activeUntil, DateTime activeUntil2);
    List<UserOB> findByEmailStartsWith(String email);
    List<UserOB> findByEmailEquals(String email);
    List<UserOB> findByIdEquals(Long id);
}
