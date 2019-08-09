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
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user;
            user = (User)session.load(User.class,Long.parseLong(id));
            session.delete(user);
            transaction.commit();
            session.close() ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("update User set name = :newName, password = :newPassword where id = :paramName");
            query.setParameter("newName", user.getName());
            query.setParameter("newPassword", user.getPassword());
            query.setParameter("paramName", user.getId());
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectData() {
        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from User");
            List<User> list =  query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectDataById(String id) {
            try {
                Session session = sessionFactory.openSession();
                Query query = session.createQuery("from User where id =:paramName");
                query.setParameter("paramName", Long.parseLong(id));
                return (User) query.uniqueResult();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }



