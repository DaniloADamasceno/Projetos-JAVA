package entities;

public class Department {

  private String name;

  //----------------------------------
  //          Constructors
  //----------------------------------
  public Department(String name) {
    this.name = name;
  }

  public Department() {}

  //----------------------------------
  //          Getters and Setters
  //----------------------------------
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
