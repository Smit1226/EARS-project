package Controllers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.*;
import Services.*;

public class FacultySearchController {
  // for regular user
  public ArrayList<FacultySearchEntity> listUserAllFacultySearch(Integer userId) {

    FacultySearchService service = new FacultySearchService();
    return service.listUserAllFacultySearch(userId);
  }

  public ArrayList<FacultySearchEntity> listAllFacultySearches() {

    FacultySearchService service = new FacultySearchService();
    return service.listAllFacultySearch();
  }

  public static void createFacultySearch(FacultySearchEntity fSearchEntity, ArrayList<Integer> memberUserIds,
      Integer chairId) throws SQLException {
    fSearchEntity.setStatus("active");
    FacultySearchEntity newFacultySearch = FacultySearchService.createFacultySearch(fSearchEntity);
    // create membere
    for (Integer userId : memberUserIds) {
      String role = "member";
      FacultySearchService.assignUserToFacultySearch(userId, newFacultySearch.getId(), role);
    }
    String role = "chair";
    FacultySearchService.assignUserToFacultySearch(chairId, newFacultySearch.getId(), role);

  }

  public static void createFacultySearch(String text, Date valueOf, Date valueOf2) {
  }
}