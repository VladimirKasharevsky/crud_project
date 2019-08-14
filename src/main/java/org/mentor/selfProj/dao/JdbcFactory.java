package org.mentor.selfProj.dao;

public class JdbcFactory implements Factory {
    @Override
    public UserDao getDao() {
        return new UserDaoJdbcImpl();
    }
}
