package org.mentor.selfProj.dao;

public class UserDaoFactory {

    public UserDao userDao(String typeOfDao){
        switch(typeOfDao){
            case "JDBC": return  new JdbcDao().getDao();
            case "HIBERNATE": return  new HibernateDao().getDao();
            default: return null;
        }
    }
}
