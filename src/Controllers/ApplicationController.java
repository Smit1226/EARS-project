package Controllers;

import java.util.ArrayList;

import Entities.ApplicationEntity;
import Services.*;

public class ApplicationController {
  ApplicationService applicationService;

  public ApplicationController() {
    ApplicationService applicationService = new ApplicationService();
    this.applicationService = applicationService;
  }

  public ApplicationEntity getApplication(Integer applicationId) {
    // call the get application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity gettedApplication = applicationService.getApplication(applicationId);
    return gettedApplication;
  } // End of getApplication method

  public ApplicationEntity acceptApplication(Integer applicationId) {
    // call the accept application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity acceptedApplication = applicationService.acceptApplication(applicationId);
    return acceptedApplication;
  } // End of acceptApplication method

  public ApplicationEntity rejectApplication(Integer applicationId) {
    // call the reject application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity rejectedApplication = applicationService.rejectApplication(applicationId);
    return rejectedApplication;
  } // End of rejectApplication method

  public ApplicationEntity saveComment(Integer applicationId, String comment, Integer userId) {
    // call the save application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity savedComment = applicationService.saveComment(applicationId, comment, userId);
    return savedComment;
  } // End of saveComment method

  public ApplicationEntity updateComment(Integer applicationId, String comment) {
    // call the update application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity updatedComment = applicationService.updateComment(applicationId, comment);
    return updatedComment;
  } // End of updateComment method

  public ApplicationEntity deleteComment(Integer applicationId) {
    // call the delete application service
    ApplicationService applicationService = new ApplicationService();
    ApplicationEntity deletedComment = applicationService.deleteComment(applicationId);
    return deletedComment;
  } // End of updateComment method

}
