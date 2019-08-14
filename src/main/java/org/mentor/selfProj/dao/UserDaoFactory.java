package org.mentor.selfProj.dao;

public class UserDaoFactory {

    public Factory setUserDaoFactory(String typeOfDao){
        switch(typeOfDao){
            case "JDBC": return  new JdbcFactory();
            case "HIBERNATE": return  new HibernateFactory();
            default: return null;
        }
    }
}
