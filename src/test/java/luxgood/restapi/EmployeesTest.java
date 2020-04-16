package luxgood.restapi;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeesTest extends BaseAPITest {

  private Employee employee;
  private EmployeeService empSrv;

  @BeforeTest
  public void prepareEmployeeData() {
    empSrv = new EmployeeService();
    employee = new Employee();
    employee
        .setAge(RandomUtils
            .nextInt(25, 67));
    employee
        .setName("Eustachy Motyka");
    employee
        .setSalary(RandomUtils
            .nextInt(8000, 15500));
  }

  @Test
  public void createEmployee() {

    Integer recentEmpId = empSrv
        .createEmployee(employee)
        // .prettyPeek()
        .then()
        .body("status", equalTo("success"))
        .rootPath("data")
        .body("name", equalTo(employee
            .getName()))
        .body("age", equalTo(employee
            .getAge()))
        .body("salary", equalTo(employee
            .getSalary()))
        .assertThat()
        .statusCode(200)
        .extract()
        .path("data.id");
    
    Assert
        .assertNotEquals(recentEmpId, null);

  }

  @Test(dependsOnMethods = {"createEmployee"})
  public void getEmployees() {
    empSrv
        .getEmployees()
        // .prettyPeek()
        .then()
        .rootPath("data")
        .body("employee_name", hasItems(employee
            .getName()))
        .statusCode(200);
  }

  @Test(dependsOnMethods = {"createEmployee"})
  public void updateEmpolyee() {

    employee
        .setName("XXXXY");

    empSrv
        .updateEmployee(2, employee)
        // .prettyPeek()
        .then()
        .statusCode(200)
        .body("status", is("success"))
        .body("data.employee_name", is(employee
            .getName()));
  }


  // to api tylko fejkuje dodanie zasobu, wiec korzystam z istniejacego id
  @Test(dependsOnMethods = {"createEmployee"})
  public void getEmployee() {
    empSrv
        .getEmployee(3)
        // .prettyPeek()
        .then()
        .statusCode(200)
        .body("status", is("success"))
        .body("data.employee_age", comparesEqualTo("66"))
        .body("data.employee_name", is("Ashton Cox"));

  }



}
