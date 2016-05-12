package com.elista.inout.repository;

import com.elista.inout.ob.InOutOB;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-11.
 */

@Transactional
@RepositoryRestResource(collectionResourceRel = "inouts", path="inouts")
public interface IInOutRepository extends JpaRepository<InOutOB, Long> {
    List<InOutOB> findByDateFromBetween(DateTime dateFrom, DateTime dateFrom2);
}