package com.elista.plan.repository;

import com.elista.plan.ob.PlanOB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-04.
 */

@Transactional
@org.springframework.stereotype.Repository
@RepositoryRestResource(collectionResourceRel = "plans", path = "plans")
public interface IPlanRepository extends JpaRepository<PlanOB, Long> {
    List<PlanOB> findByNameStartsWith(@Param("name") String name);
    List<PlanOB> findByCodeStartsWith(@Param("code") String code);
    @Query("SELECT p FROM PlanOB p JOIN p.users u where u.id = ?1")
    List<PlanOB> findByUserId(@Param("user_id") Long id);
}
