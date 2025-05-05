package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {
    
    private Connection connect;

    public dbConnector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/task-managerdb", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        return rst;
    }

    public boolean insertData(String sql) {
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }

    public void updateData(String sql) {
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }

    public boolean deleteUserById(String id) {
        String sql = "DELETE FROM tbl_user WHERE u_id = ?";
        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, id);
            int rowsAffected = pst.executeUpdate();
            pst.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Delete Error: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean deleteTaskById(String id) {
        String query = "DELETE FROM tbl_tasks WHERE t_id = ?";
        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Returns true if a row was deleted
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        }
    }

   
    public boolean logAction(int userId, String action) {
        String query = "INSERT INTO logs (user_id, action, timestamp) VALUES (?, ?, NOW())";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, action);
            int rowsAffected = stmt.executeUpdate();
            
           
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error logging action: " + e.getMessage());
            return false;
        }
    }

    public Connection getConnection() {
        return connect;
    }
}
