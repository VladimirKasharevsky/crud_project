package org.mentor.selfProj.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mentor.selfProj.model.UsersDataSet;


public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }


    public UsersDataSet getUserId(String name, String password) throws HibernateException {
        Query query = session.createQuery("from UsersDataSet where name =:paramName");
        query.setParameter("paramName", name);

       return (UsersDataSet) query.uniqueResult();
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
