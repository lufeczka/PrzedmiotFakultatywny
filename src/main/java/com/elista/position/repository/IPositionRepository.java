package com.elista.position.repository;

import com.elista.position.ob.positionOB;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Thru on 2016-05-04.
 */
@RepositoryRestResource(collectionResourceRel = "positions", path = "positions")
public interface IPositionRepository extends PagingAndSortingRepository<positionOB, Long> {
    List<positionOB> findByNameStartsWith(@Param("name") String name);
    List<positionOB> findByCodeStartsWith(@Param("code") String code);
    List<positionOB> findByDivisionStartsWith(@Param("division") String division);
    List<positionOB> findByNameEquals(@Param("name") String name);
    List<positionOB> findByCodeEquals(@Param("code") String code);
    List<positionOB> findByDivisionEquals(@Param("division") String division);
}
