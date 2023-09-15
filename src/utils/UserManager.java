package utils;

import classes.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {

    public static User signIn(String username, String password) {
        String sqlSelect = "SELECT * FROM doc_connect.patient WHERE UserName = " + "'" + username + "'" + " AND PatPass = " + "'" + password + "'";
        User foundUser = null;

        try {

            Connection con = DatabaseManager.getConnection();

            assert con != null;
            ResultSet rs = con.createStatement().executeQuery(sqlSelect);

            if (rs.next()) {
                String patUsername = rs.getString("UserName");
                String patPassword = rs.getString("PatPass");
                String patName = rs.getString("PatName");

                foundUser = new User(patUsername, patPassword, patName);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return foundUser;
    }

    public static String signUp(String username, String password, String name) {
        String sqlInsert = "INSERT INTO doc_connect.patient (`UserName`, `PatPass`, `PatName`) VALUES ('" + username + "', '" + password + "', '" + name + "')";
        String sqlSelect = "SELECT * FROM doc_connect.patient WHERE UserName = " + "'" + username + "'";
        String error = null;

        try {

            Connection con = DatabaseManager.getConnection();

            assert con != null;
            Statement stmt = con.createStatement();

            if (!username.equals("") && !name.equals("") && !password.equals("")) {
                ResultSet rs = con.createStatement().executeQuery(sqlSelect);

                if (rs.next()) {
                    error = "Username has been used. Please use another username";
                } else {
                    stmt.execute(sqlInsert);
                }

            } else {
                error = "Please type all information";
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return error;
    }
}