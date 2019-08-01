package org.mentor.selfProj.dao;

import org.mentor.selfProj.model.User;

import java.sql.*;

public class Dao implements UserDao {

    private final Connection connection;

    public Dao(Connection connection) {

        this.connection = connection;

    }

    @Override
    public void insertUserPrep(User user) throws SQLException {
        String sql = "insert into users (name, password) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();
    }

    @Override
    public void dellUserPrep(String id) throws SQLException {
        String sql = "delete from users where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserPrep(User user, String id) throws SQLException {
            String sql = "update users set name = ?, password = ? where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();

    }

    @Override
    public ResultSet selectData() throws SQLException {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from users");
            return result;
    }
}

