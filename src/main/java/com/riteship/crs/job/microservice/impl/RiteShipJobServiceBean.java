package com.riteship.crs.job.microservice.impl;

import com.riteship.common.apis.services.impls.RiteShipGeneralServiceImpl;
import com.riteship.crs.job.microservice.RiteShipJobDBOperationsBean;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RiteShipJobServiceBean<JobDataBean, Integer> extends RiteShipGeneralServiceImpl<JobDataBean, Integer> {

        @PostConstruct
        public void initializeBean() {
            setRiteShipDatabaseOperationsBean(new RiteShipJobDBOperationsBean().getDatabaseOperationsBean());
        }

}
