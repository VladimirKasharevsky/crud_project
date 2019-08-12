package org.mentor.selfProj.dao;

public class UserDaoFactory implements Factory{

    @Override
    public UserDao getDao(String typeOfDao) {
        switch (typeOfDao) {
            case "JDBC":
                return new UserDaoJdbcImpl();
            case "HIBERNATE":
                return new UserDaoHibernateImpl();
            default:
                return null;
        }
    }

//    @Override
//    public UserDao getDao(String typeOfDao) {
//        return null;
//    }
}
