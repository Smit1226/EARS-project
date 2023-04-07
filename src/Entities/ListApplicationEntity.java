package Entities;

import java.sql.Timestamp;

public class ListApplicationEntity {
    private Integer id;
    private String status;
  
    private String applicantName;
 
    private Timestamp submitDate;

    public Integer getId() {
      return id;
    }
  
    public void setId(Integer id) {
      this.id = id;
    }
  
    public String getApplicantName() {
      return applicantName;
    }
  
    public void setApplicantName(String applicantName) {
      this.applicantName = applicantName;
    }
  
  
    public String getStatus() {
      return status;
    }
  
    public void setStatus(String status) {
      this.status = status;
    }
  
    
  
    // Setter for submitDate
    public void setSubmitDate(Timestamp submitDate) {
      this.submitDate = submitDate;
    }
  
    // Getter for submitDate
    public Timestamp getSubmitDate() {
      return submitDate;
    }
  
}
