package org.mentor.selfProj.dao;

public class HibernateDao implements Factory {
    @Override
    public UserDao getDao() {
        return new UserDaoHibernateImpl();
    }
}
