package com.teresol.revision.Connections;
import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class StudentDataSource {

    @Inject
    AgroalDataSource studentSource;

    @Inject
    Logger log;

    public Connection getConnection() {
        try {
                return studentSource.getConnection();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
