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
//    @Query("SELECT SUM(FUNC('TIME_TO_SEC', inout.timeFrom)) from InOutOB inout JOIN inout.users u where u.id = ?1")
//    List<DateTime> findTimeByUserId(@Param("user_id") Long id);
    /*

    @Query("SELECT ps FROM PlanSpecOB ps JOIN ps.plan p JOIN p.users u where u.id = ?1")
    List<PlanSpecOB> findByUserId(@Param("user_id") Long id);
     */
}