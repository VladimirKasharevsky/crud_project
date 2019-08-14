package org.mentor.selfProj.dao;

import org.mentor.selfProj.helpclasses.PropClass;

import java.io.IOException;

public class UserDaoFactory {

    private String property;
    {
        try {
            String property = PropClass.getProp("typeOfDao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Factory getUserDaoFactoryByProperty() {
        switch (property) {
            case "JDBC":
                return new JdbcFactory();
            case "HIBERNATE":
                return new HibernateFactory();
            default:
                return new JdbcFactory();
        }
    }
}
