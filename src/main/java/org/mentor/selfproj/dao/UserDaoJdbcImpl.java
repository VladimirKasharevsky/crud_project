package org.mentor.selfproj.dao;

import org.mentor.selfproj.config.DBHelper;
import org.mentor.selfproj.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

//    private final  Connection connection = DBConfigJdbc.getMysqlConnection();
    private final  Connection connection =  DBHelper.getDbHelper().getConnection();

    @Override
    public void createUser(User user) {
        String sql = "insert into users (name, password, role) values (?,?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());

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
        String sql = "update users set name = ?, password = ?, role = ?  where id = ?";

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, String.valueOf(user.getId()));

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
                User user = new User(result.getLong("id"),result.getString("name"),result.getString("password"), result.getString("role") );
//                user.setId(result.getLong("id"));
//                user.setName(result.getString("name"));
//                user.setPassword(result.getString("password"));
//                user.setRole(result.getString("role"));
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
                User retUser = new User(result.getLong("id"),result.getString("name"), result.getString("password"),result.getString("role"));
                user = retUser;
//                user.setId(result.getLong("id"));
//                user.setName(result.getString("name"));
//                user.setPassword(result.getString("password"));
//                user.setRole(result.getString("role"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

