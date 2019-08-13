package org.mentor.selfProj.service;

import org.mentor.selfProj.dao.UserDao;
import org.mentor.selfProj.dao.UserDaoFactory;
import org.mentor.selfProj.help_classes.PropClass;
import org.mentor.selfProj.model.User;

import java.io.IOException;
import java.util.List;

public class UserServiceClass implements UserService {


//    UserDao userDao = new UserDaoJdbcImpl();
//    UserDao userDao = new UserDaoHibernateImpl();
//     UserDao userDao;

    String property;
    {
        try {
          property = PropClass.getProp("typeOfDao");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    UserDao userDao = new UserDaoFactory().userDao(property);



    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public List listData() {
        return userDao.selectData();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.selectDataById(id);
    }
}
