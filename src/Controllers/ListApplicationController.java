package Controllers;
import java.sql.SQLException;

import Entities.*;
import Services.ListApplicationService;
import javafx.collections.ObservableList;

public class ListApplicationController {
    ListApplicationService listApplicationService;

    public ListApplicationController() {
      ListApplicationService listApplicationService = new ListApplicationService();
      this.listApplicationService = listApplicationService;
    }
  
    public ObservableList<ListApplicationEntity> listFacultySearchApplications(Integer facultySearchId) throws SQLException {
      ListApplicationService listApplicationService = new ListApplicationService();
      ObservableList<ListApplicationEntity> listedApplications = listApplicationService.listFacultySearchApplications(facultySearchId);
      return listedApplications;
    }
}
