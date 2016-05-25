package com.elista.position.service;

import com.elista.position.ob.positionOb;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thrundi on 2016-05-25.
 */
@Service
@Transactional
public interface IPositionService {
    Long savePosition (positionOb positionOb);
    positionOb getPositionById(Long position_id);
}
