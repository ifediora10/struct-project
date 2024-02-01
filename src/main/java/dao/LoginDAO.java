package dao;

import dbutil.DBUtil;
import pojo.LoginInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

    public static boolean isUserValid(LoginInfo userDetails) {
        boolean validStatus = false;

        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM users WHERE username = '" + userDetails.getUsername() + "' AND password = '" + userDetails.getPassword() + "'");

            while (resultSet.next()) {
                validStatus = true;
            }
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return validStatus;
    }
}
