package org.mentor.selfproj.dao;

public class JdbcFactoryImpl implements Factory {
    @Override
    public UserDao getUserDao() {
        return new UserDaoJdbcImpl();
    }
}
