package com.elista.inout.repository;

import com.elista.inout.ob.InOutOB;
import com.elista.user.ob.UserOB;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-11.
 */

@Transactional
@org.springframework.stereotype.Repository
@RepositoryRestResource(collectionResourceRel = "inouts", path="inouts")
public interface IInOutRepository extends JpaRepository<InOutOB, Long> {
    List<InOutOB> findByDateFromBetween(DateTime dateFrom, DateTime dateFrom2);
    List<InOutOB> findByDateToBetween(DateTime dateFrom, DateTime dateFrom2);
    List<InOutOB> findByDateFromLessThanAndDateFromGreaterThan(DateTime dateFrom, DateTime dateFrom2);
    List<InOutOB> findByUser(UserOB user);
    List<InOutOB> findByUserAndDateToIsNull(UserOB user);
}