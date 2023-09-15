package utils;

import classes.Appointment;
import classes.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AppointManager {

    public static void addAppointment(Appointment appointment) {
        String sqlSelect = "SELECT * FROM doc_connect.department WHERE Dname = '" + appointment.getDepartment() + "'";
        int idDept = 0;

        try {

            Connection con = DatabaseManager.getConnection();

            assert con != null;
            Statement stmt = con.createStatement();

            ResultSet rs = con.createStatement().executeQuery(sqlSelect);

            if (rs.next()) {
                idDept = rs.getInt("idDept");
            }

            String sqlInsert = "INSERT INTO doc_connect.appointment (`Date`, `Time`, `UserName`, `Pnumber`, `idDept`) VALUES ('" + appointment.getDate() + "', '" + appointment.getTime() + "', '" + appointment.getUsername() + "', '" + appointment.getPhoneNumber() + "', " + idDept + ")";

            stmt.execute(sqlInsert);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean removeAppointment(String appID, String username, String password) {
        String sqlSelect = "SELECT * FROM doc_connect.patient INNER JOIN appointment ON patient.UserName = appointment.UserName WHERE appointment.AppID = " + appID + " AND patient.UserName = " + "'" + username + "' AND patient.PatPass = " + "'" + password + "'";
        String sqlDelete = "DELETE FROM doc_connect.appointment WHERE AppID = " + appID + " AND UserName = " + "'" + username + "'";

        try {

            Connection con = DatabaseManager.getConnection();

            assert con != null;
            Statement stmt = con.createStatement();

            ResultSet rs = con.createStatement().executeQuery(sqlSelect);

            if (rs.next()) {
                stmt.execute(sqlDelete);
                return true;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return false;
    }

    public static ArrayList<Appointment> getAllAppointments(User user) {
        String sqlSelect = "SELECT * FROM doc_connect.appointment INNER JOIN department ON appointment.idDept = department.idDept WHERE UserName = " + "'" + user.getUsername() + "'";
        ArrayList<Appointment> appointments = new ArrayList<>();

        try {

            Connection con = DatabaseManager.getConnection();

            assert con != null;
            ResultSet rs = con.createStatement().executeQuery(sqlSelect);

            while (rs.next()) {
                String appID = String.valueOf(rs.getInt("AppID"));
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                String name = rs.getString("UserName");
                String phone = rs.getString("Pnumber");
                String dept = rs.getString("Dname");

                appointments.add(new Appointment(appID, date, time, phone, dept, name));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return appointments;
    }
}