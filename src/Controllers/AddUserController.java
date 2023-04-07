package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.DepartmentEntity;
import Services.AddUserService;

public class AddUserController {
    public static void addUserToMysql(String firstName, String lastName, String email, String password, String role, Integer departmentId){
        AddUserService.addUserToMysql(firstName, lastName, email, password, role, departmentId);
    }



    public static ArrayList<DepartmentEntity> getDepartmentList() throws ClassNotFoundException, SQLException{
        return AddUserService.getDepartmentList();   
    }
}
