package org.mentor.selfProj.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mentor.selfProj.config.DBConfigHibernate;
import org.mentor.selfProj.model.User;

import java.util.List;

public class UserDaoHibernate implements UserDao{

    Configuration configuration = DBConfigHibernate.getMySqlConfiguration();
    private final SessionFactory sessionFactory = DBConfigHibernate.createSessionFactory(configuration);;

    @Override
    public void createUser(User user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> selectData() {
        try {
            Session session = sessionFactory.openSession();
//            Query query = session.createQuery("from User where name =:paramName");
            Query query = session.createQuery("from User");
//            query.setParameter("paramName", name);
            List<User> list =  query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

//        try {
//            Session session = sessionFactory.openSession();
//            UserDaoHibernate dao = new UserDaoHibernate(session);
//            User dataSet = dao.getUserId(name, password);
//            session.close();
//            return dataSet;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return null;
//        }

    }

    @Override
    public User selectDataById(String id) {
        return null;
    }


//    public User getUserId(String name, String password) throws HibernateException {
//        Query query = session.createQuery("from UsersDataSet where name =:paramName");
//        query.setParameter("paramName", name);
//
//       return (User) query.uniqueResult();
//    }
//
//    public long insertUser(String name, String password) throws HibernateException {
//        return (Long) session.save(new User(name, password));
//    }


}
