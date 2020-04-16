package luxgood.restapi;

import com.github.javafaker.Faker;

public class Employee {

  private Integer id;
  private String name;
  private int salary;
  private int age;

  public Employee() {

  }

  public Employee(boolean isFake) {
    
    Faker fk = new Faker();
    
    this.name = fk
        .name() + " "
        + fk
            .funnyName();

    this.salary = fk
        .random()
        .nextInt(8000, 15000);
    this.age = fk
        .random()
        .nextInt(22, 47);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
  }



}
