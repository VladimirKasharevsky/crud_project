package org.mentor.selfProj.dao;

public class UserDaoFactory {


    public UserDao userDao(String typeOfDao){
        switch(typeOfDao){
            case "JDBC": return new UserDaoJdbcImpl();
            case "HIBERNATE": return new UserDaoHibernateImpl();
            default: return null;
        }
        }
}
