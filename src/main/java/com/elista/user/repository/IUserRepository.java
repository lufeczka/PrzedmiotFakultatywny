package com.elista.user.repository;

import com.elista.user.ob.UserOB;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Thrundi on 2016-05-03.
 */
public interface IUserRepository extends JpaRepository<UserOB, Long> {

}
