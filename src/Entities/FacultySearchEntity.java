package Entities;

import java.util.Date;

public class FacultySearchEntity {

  private Date startDate;
  private Date endDate;
  private String status;
  private Integer id;
  private String title;

  public FacultySearchEntity() {

  }

  public FacultySearchEntity(String title, Date startDate, Date endDate) {
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String gettitle() {
    return title;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEnDate(Date enDate) {
    this.endDate = enDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
