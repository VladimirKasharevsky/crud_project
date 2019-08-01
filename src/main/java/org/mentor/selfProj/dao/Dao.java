package org.mentor.selfProj.dao;

import org.mentor.selfProj.model.User;

import java.sql.*;

public class Dao implements UserDao {

    private final Connection connection;

    public Dao(Connection connection) {

        this.connection = connection;

    }

    @Override
    public void addUser(User user) {
        String sql = "insert into users (name, password) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from users where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user, String id) {
        String sql = "update users set name = ?, password = ? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ResultSet selectData() {

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from users");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet selectDataById(User user) {
        String sql = "select * from users where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(user.getId()));
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

