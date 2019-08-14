package org.mentor.selfProj.dao;

public class HibernateFactory implements Factory {
    @Override
    public UserDao getUserDao() {
        return new UserDaoHibernateImpl();
    }
}
