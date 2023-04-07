package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.Database;
import Entities.DepartmentEntity;

public class AddUserService{
    public static void  addUserToMysql(String firstName, String lastName, String email, String password, String role, Integer departmentId) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (firstName, lastName, email, password, role, departmentId) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, role);
            stmt.setInt(6,departmentId);
            stmt.executeUpdate();
            System.out.println("Uer added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static ArrayList<DepartmentEntity>  getDepartmentList()  throws SQLException, ClassNotFoundException{
        Connection conn = Database.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
        ArrayList<DepartmentEntity> departmentList = new ArrayList<DepartmentEntity>();
        while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");


        departmentList.add(new DepartmentEntity(id,name));
        }
        return departmentList;
  }

}
