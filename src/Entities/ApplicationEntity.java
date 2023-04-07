package Entities;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ApplicationEntity {

  private Integer id;

  private String status;

  private String firstName, lastName, phone, email, address, city, province, position, department, experience1,
      experience2, education1, education2, content;

  private LocalDate assignedDate;
  private Timestamp submitDate;
  private String assignTo;
  private String facultySearchId;
  private String applicantName;

  public String getApplicantName() {
    return applicantName;
  }

  public void setApplicantName(String applicantName) {
    this.applicantName = applicantName;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getExperience1() {
    return experience1;
  }

  public void setExperience1(String experience1) {
    this.experience1 = experience1;
  }

  public String getExperience2() {
    return experience2;
  }

  public void setExperience2(String experience2) {
    this.experience2 = experience2;
  }

  public String getEducation1() {
    return education1;
  }

  public void setEducation1(String education1) {
    this.education1 = education1;
  }

  public String getEducation2() {
    return education2;
  }

  public void setEducation2(String education2) {
    this.education2 = education2;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  // Setter for assignedDate
  public void setAssignedDate(LocalDate assignedDate) {
    this.assignedDate = assignedDate;
  }

  // Getter for assignedDate
  public LocalDate getAssignedDate() {
    return assignedDate;
  }

  // Setter for submitDate
  public void setSubmitDate(Timestamp submitDate) {
    this.submitDate = submitDate;
  }

  // Getter for submitDate
  public Timestamp getSubmitDate() {
    return submitDate;
  }

  // Setter for assignTo
  public void setAssignTo(String assignTo) {
    this.assignTo = assignTo;
  }

  // Getter for assignTo
  public String getAssignTo() {
    return assignTo;
  }

  // Setter for facultySearchId
  public void setFacultySearchId(String facultySearchId) {
    this.facultySearchId = facultySearchId;
  }

  // Getter for facultySearchId
  public String getFacultySearchId() {
    return facultySearchId;
  }
}
