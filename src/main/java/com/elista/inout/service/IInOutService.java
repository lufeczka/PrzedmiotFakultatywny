package com.elista.inout.service;

import com.elista.inout.ob.InOutOB;
import org.jvnet.hk2.annotations.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-16.
 */

@Service
@Transactional
public interface IInOutService {
    String inOut(Long user_id);
    List<InOutOB> findByUserId(Long user_id);
}
