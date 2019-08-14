package org.mentor.selfProj.dao;

public class HibernateFactory implements Factory {
    @Override
    public UserDao getDao() {
        return new UserDaoHibernateImpl();
    }
}
