package org.mentor.selfproj.dao;

import org.mentor.selfproj.helpclasses.PropClass;

import java.io.IOException;

public class UserDaoFactory {

    private String property;
    {
        try {
             property = PropClass.getProp("typeOfDao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Factory getUserDaoFactoryByProperty() {
        switch (property) {
            case "JDBC":
                return new JdbcFactoryImpl();
            case "HIBERNATE":
                return new HibernateFactoryImpl();
            default:
                return new JdbcFactoryImpl();
        }
    }
}
