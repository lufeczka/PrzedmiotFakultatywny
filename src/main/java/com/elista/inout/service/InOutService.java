package com.elista.inout.service;

import com.elista.inout.ob.InOutOB;
import com.elista.inout.repository.IInOutRepository;
import com.elista.user.repository.IUserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-16.
 */

@Service
@Transactional
public class InOutService implements IInOutService {

    @Autowired
    IInOutRepository iInOutRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    EntityManager entityManager;

    public InOutService() {
    }

    @Override
    public String inOut(Long user_id) {
        InOutOB inout;
        String result;
        List<InOutOB> inoutlist = iInOutRepository.findByUserAndDateToIsNull(iUserRepository.findOne(user_id));
        if (inoutlist.isEmpty()) {
            inout = new InOutOB(iUserRepository.findOne(user_id));
            iInOutRepository.save(inout);
            result = "Wejscie: " + inout.getUser().getName() + " " + inout.getUser().getSurname() + ". " + inout.getDateFrom();
        }
        else {
            inout = inoutlist.get(0);
            inout.setDateTo(DateTime.now().toDateTime());
            iInOutRepository.save(inout);
            result = "Wyjscie: " + inout.getUser().getName() + " " + inout.getUser().getSurname() + ". " + inout.getDateTo();
        }
        return result;
    }

    @Override
    public List<InOutOB> findByUserId(Long user_id) {
        return iInOutRepository.findByUser(iUserRepository.findOne(user_id));
    }

    public DateTime timeToday (Long user_id) {
        String str = "Select sum(inouts.dateTo - inouts.dateFrom) from inouts where inouts.user_id = :user_id";
        Query query = (Query) entityManager.createNativeQuery(str, DateTime.class);
        query.setParameter("user_id", user_id);
        List<DateTime> result = query.getResultList();
        return result.get(0).toDateTime();
    }
}
