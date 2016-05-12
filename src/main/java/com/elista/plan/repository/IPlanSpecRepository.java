package com.elista.plan.repository;

import com.elista.plan.ob.PlanSpecOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.security.Timestamp;
import java.sql.Time;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-04.
 */
@RepositoryRestResource(collectionResourceRel = "plans_spec", path = "plans_spec")
public interface IPlanSpecRepository extends JpaRepository<PlanSpecOB, Long> {
    List<PlanSpecOB> findByDayOfWeekEquals(@Param("dayofweek") Short dayofweek);
    List<PlanSpecOB> findByPlan_CodeStartsWith(@Param("plan_code") String plan_code);
    List<PlanSpecOB> findByPlan_NameStartsWith(@Param("plan_name") String plan_name);
    @Query("SELECT p from PlanSpecOB p WHERE p.dayOfWeek = ?1 AND ?2 BETWEEN p.timeFrom and p.timeTo")
    List<PlanSpecOB> findByDate(@Param("dayofweek") Short dayofweek, @Param("time") Time time);
    @Query("SELECT ps FROM PlanSpecOB ps JOIN ps.plan p JOIN p.users u where u.id = ?1")
    List<PlanSpecOB> findByUserId(@Param("user_id") Long id);
}
