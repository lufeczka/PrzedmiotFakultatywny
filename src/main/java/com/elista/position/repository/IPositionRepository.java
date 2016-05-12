package com.elista.position.repository;

import com.elista.position.ob.positionOb;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Thru on 2016-05-04.
 */
@RepositoryRestResource(collectionResourceRel = "positions", path = "positions")
public interface IPositionRepository extends PagingAndSortingRepository<positionOb, Long> {
    List<positionOb> findByNameStartsWith(@Param("name") String name);
    List<positionOb> findByCodeStartsWith(@Param("code") String code);
    List<positionOb> findByDivisionStartsWith(@Param("division") String division);
    List<positionOb> findByNameEquals(@Param("name") String name);
    List<positionOb> findByCodeEquals(@Param("code") String code);
    List<positionOb> findByDivisionEquals(@Param("division") String division);
}
