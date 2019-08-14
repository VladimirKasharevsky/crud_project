package org.mentor.selfProj.service;

import org.mentor.selfProj.dao.UserDao;
import org.mentor.selfProj.dao.UserDaoFactory;
import org.mentor.selfProj.model.User;

import java.util.List;

public class UserServiceClass implements UserService {


    UserDao userDao = new UserDaoFactory().getUserDaoFactoryByProperty().getUserDao();


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
