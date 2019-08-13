package org.mentor.selfProj.dao;

public class JdbcDao implements Factory {
    @Override
    public UserDao getDao() {
        return new UserDaoJdbcImpl();
    }
}
