package org.mentor.selfProj.dao;

import org.mentor.selfProj.config.DBConfig;
import org.mentor.selfProj.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao implements UserDao {

    private final  Connection connection = DBConfig.getMysqlConnection();

    @Override
    public void createUser(User user) {
        String sql = "insert into users (name, password) values (?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from users where id = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user) {
        String sql = "update users set name = ?, password = ? where id = ?";

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getId()));

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List selectData() {
        List<User> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from users");
            connection.commit();

            while (result.next()) {
                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectDataById(String id) {
        User user = new User();
        String sql = "select * from users where id = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            ResultSet result = preparedStatement.executeQuery();
            connection.commit();
            while (result.next()) {
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

