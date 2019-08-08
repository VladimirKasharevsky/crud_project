package org.mentor.selfProj.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.mentor.selfProj.model.User;

public class DBConfigHibernate {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "validate";

//    private final SessionFactory sessionFactory;

//    public DBConfigHibernate() {
//        Configuration configuration = getMySqlConfiguration();
//        sessionFactory = createSessionFactory(configuration);
//    }

    public static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_example");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "admin");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }



//    public User getUserId(String name, String password)  {
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
//    }
//
//    public long addUser(String name, String password)  {
//        try {
//            Session session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//            UserDaoHibernate dao = new UserDaoHibernate(session);
//            long id = dao.insertUser(name, password);
//            transaction.commit();
//            session.close();
//            return id;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return -1;
//        }
//    }

    public static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
