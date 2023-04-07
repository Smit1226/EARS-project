package Entities;

public class MemberEntity {
  private Integer id;
  private Integer facultySearchId;
  private Integer userId;

  public Integer getFacultySearchId() {
    return facultySearchId;
  }

  public Integer getId() {
    return id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setFacultySearchId(Integer facultySearchId) {
    this.facultySearchId = facultySearchId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

}
