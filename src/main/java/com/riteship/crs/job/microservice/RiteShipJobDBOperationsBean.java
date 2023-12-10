package com.riteship.crs.job.microservice;

import com.riteship.common.apis.components.RiteShipDatabaseOperationsBean;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RiteShipJobDBOperationsBean {

    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String databaseUrl = "jdbc:mysql://localhost:3307/riteship_crs_job_microservice?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String databaseUserName = "root";

    private static String databasePassword = "RiteShip1421#$";

    private RiteShipDatabaseOperationsBean databaseOperationsBean;

    public RiteShipJobDBOperationsBean() {
        databaseOperationsBean = RiteShipDatabaseOperationsBean.getInstance(driverClassName,
                databaseUrl, databaseUserName, databasePassword);
    }

    @PostConstruct
    public void initializeJobMicroService() {
        if(databaseOperationsBean == null) {
            databaseOperationsBean = RiteShipDatabaseOperationsBean.getInstance(driverClassName,
                    databaseUrl, databaseUserName, databasePassword);
        }
    }

    public RiteShipDatabaseOperationsBean getDatabaseOperationsBean() {
        return databaseOperationsBean;
    }

    public void setDatabaseOperationsBean(RiteShipDatabaseOperationsBean databaseOperationsBean) {
        this.databaseOperationsBean = databaseOperationsBean;
    }
}
