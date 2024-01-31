package dao;

import dbutil.DBUtil;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

    // Create the 'users' table if it doesn't exist
    static {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY," +
                            "username VARCHAR(255) NOT NULL," +
                            "password VARCHAR(255) NOT NULL," +
                            "email VARCHAR(255) NOT NULL" +
                            ")");
            preparedStatement.executeUpdate();
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating 'users' table", e);
        }
    }

    public static boolean registerUser(User user) {
        boolean registrationStatus = false;

        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                registrationStatus = true;
            }

            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return registrationStatus;
    }
}
