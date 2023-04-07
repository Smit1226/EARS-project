package Entities;

public class UserEntity {
  private String email;
  private String firstName;
  private String lastName;
  private String role;

  // @todo: must hashed in bcrypt
  private String password;
  private Integer id;

  public UserEntity() {

  }

  public UserEntity(Integer id, String firstName, String lastName, String email, String role) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.role = role;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getRole() {
    return role;
  }

  public boolean isAdmin() {
    return role.equals("admin");
  }

  public String getPassword() {
    return password;
  }

  public Integer getID() {
    return id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean comparePassword(String password) {
    return this.password.equals(password);
  }

  public String toString() {
    return firstName + " " + lastName;
  }

}
