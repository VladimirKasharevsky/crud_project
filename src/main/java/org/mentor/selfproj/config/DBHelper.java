package org.mentor.selfproj.config;

import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class DBHelper {

    private static DBHelper dbHelper;

    public static DBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();

        }
        return dbHelper;
    }

    private DBHelper() {

    }
    public Connection getConnection() {
        return DBConfigJdbc.getMysqlConnection();
    }

    public Configuration getConfiguration() {
        return DBConfigHibernate.getMySqlConfiguration();
    }
}
