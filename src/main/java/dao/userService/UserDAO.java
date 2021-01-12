package dao.userService;

import dao.ConnectDB;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String INSERT_USER = "INSERT INTO user " + " (firstname,lastname,username,password,email,phoneNumber,centerId) values " + " (?,?,?,?,?,?,?);";
    private final String SELECT_USER_BY_ID = "select id,firstname,lastname,username,password,email,phoneNumber,centerId from student where id =?;";
    private final String SELECT_ALL_USER = "select * from user;";
    private final String DELETE_USER = "delete from user where id = ?;";
    private final String UPDATE_USER = "update student set firstname=?,lastname=?,username=?,password=?,email=?,phoneNumber=?,centerId=;";
    List<User> users = new ArrayList<>();

    @Override
    public boolean insertUser(User user) throws SQLException {
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setInt(7, user.getCenterId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                int centerId = resultSet.getInt("centerId");
                user = new User(firstname, lastname, username, password, email, phoneNumber, centerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        Connection connection = ConnectDB.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                int centerId = resultSet.getInt("centerId");
                users.add(new User(firstname,lastname,username,password,email,phoneNumber,centerId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection = ConnectDB.getInstance().getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(5, user.getCenterId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}
