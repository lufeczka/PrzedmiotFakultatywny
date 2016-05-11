package com.elista.position.repository;

import com.elista.position.ob.PositionOB;
import com.elista.user.ob.UserOB;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Thru on 2016-05-04.
 */
@RepositoryRestResource(collectionResourceRel = "positions", path = "positions")
public interface IPositionRepository extends PagingAndSortingRepository<PositionOB, Long> {
    List<PositionOB> findByNameStartsWith(@Param("name") String name);
    List<PositionOB> findByCodeStartsWith(@Param("code") String code);
    List<PositionOB> findByDivisionStartsWith(@Param("division") String division);
    List<PositionOB> findByNameEquals(@Param("name") String name);
    List<PositionOB> findByCodeEquals(@Param("code") String code);
    List<PositionOB> findByDivisionEquals(@Param("division") String division);
}
