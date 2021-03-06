package com.elista.appConfig;

import com.elista.inout.repository.IInOutRepository;
import com.elista.inout.service.IInOutService;
import com.elista.inout.service.InOutService;
import com.elista.plan.service.PlanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Thrundi on 2016-05-17.
 */

@Configuration
public class AppConfig {
    @Bean
    public PlanService planService(){
        return new PlanService();
    }

    @Bean
    public IInOutService iInOutService() { return new InOutService(); }
}
