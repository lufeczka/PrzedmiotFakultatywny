package com.elista.position.service;

import com.elista.position.ob.positionOb;
import com.elista.position.repository.IPositionRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thrundi on 2016-05-25.
 */
@Service
@Transactional
public class PositionService implements IPositionService{

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public Long savePosition(positionOb position_ob) {
        if (position_ob == null)
            return Long.valueOf(0);
        iPositionRepository.save(position_ob);
        return position_ob.getId();
    }

    @Override
    public positionOb getPositionById(Long position_id) {
        return iPositionRepository.findOne(position_id);
    }
}