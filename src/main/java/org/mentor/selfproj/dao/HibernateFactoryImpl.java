package org.mentor.selfproj.dao;

public class HibernateFactoryImpl implements Factory {
    @Override
    public UserDao getUserDao() {
        return new UserDaoHibernateImpl();
    }
}
