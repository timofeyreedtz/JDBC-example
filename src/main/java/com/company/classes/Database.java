package com.company.classes;
import com.company.models.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String SQL_DELETE = "DELETE FROM table_of_user WHERE (name,birthdate,birthplace) = (? ,? ,?)";
    private static final String SQL_ADD = "INSERT INTO table_of_user(name,birthdate,birthplace) "
            + "VALUES(?,?,?)";
    private static final String SQL_FIND = "SELECT * FROM table_of_user";
    public static List<User> getTable() {
        List<User> userList = new ArrayList<>();
        try {
            Connection con = PropertiesDownload.downloadProps().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_FIND);
            while (rs.next()) {
                userList.add(new User(rs.getString("name"), rs.getString("birthdate"),
                        rs.getString("birthplace")));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return userList;
    }

    public static void addRow(User user_) {
        try {
            Connection con = PropertiesDownload.downloadProps().getConnection();
            PreparedStatement pstmt = con.prepareStatement(SQL_ADD,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user_.getName());
            pstmt.setString(2, user_.getBirthdate());
            pstmt.setString(3, user_.getBirthplace());
            pstmt.execute();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Database.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void deleteRow(User user_) {
        try {
            Connection con = PropertiesDownload.downloadProps().getConnection();
            PreparedStatement pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, user_.getName());
            pstmt.setString(2, user_.getBirthdate());
            pstmt.setString(3, user_.getBirthplace());
            pstmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
