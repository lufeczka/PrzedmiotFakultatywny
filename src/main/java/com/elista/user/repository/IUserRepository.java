package com.elista.user.repository;

import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface IUserRepository extends PagingAndSortingRepository<UserOB, Long> {
    List<UserOB> findByNameStartsWith(@Param("name") String name);
    List<UserOB> findBySurnameStartsWith(@Param("surname") String surname);
    List<UserOB> findByNameStartsWithOrSurnameStartsWith(@Param("name") String name, @Param("surname") String surname);
    List<UserOB> findByNameEqualsAndSurnameEquals(@Param("name") String name, @Param("surname") String surname);
    List<UserOB> findByActiveUntilBetween(@Param("activeFrom") DateTime activeFrom, @Param("activeTo") DateTime activeTo);
    List<UserOB> findByEmailStartsWith(@Param("email") String email);
    List<UserOB> findByEmailEquals(@Param("email") String email);
    List<UserOB> findByIdEquals(@Param("id") Long id);
}
