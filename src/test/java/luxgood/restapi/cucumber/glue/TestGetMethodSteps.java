package luxgood.restapi.cucumber.glue;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import luxgood.restapi.Employee;
import luxgood.restapi.EmployeeService;

public class TestGetMethodSteps {
  List<Employee> emps = new ArrayList<Employee>();
  private EmployeeService empSrv;
  private Response response;

  private void prepareForRestAssured() {
    RestAssured.baseURI = "http://dummy.restapiexample.com/";
    RestAssured.basePath = "api/v1";
    empSrv = new EmployeeService();
  }

  @Given("I want to execute \\/employees endpoint")
  public void i_want_to_execute_employees_endpoint() {
    prepareForRestAssured();
  }

  @Given("I want to execute \\/create endpoint")
  public void i_want_to_execute_create_endpoint() {
    prepareForRestAssured();
  }

  @When("I submit the GET request")
  public void i_submit_the_GET_request() {

    response = empSrv
        .getEmployees();

  }

  @When("I submit the POST request")
  public void i_submit_the_POST_request() {

    Employee emp = new Employee("Hilary", 5678, 67);
    
    response = empSrv
        .createEmployee(emp)
        .prettyPeek();
  }

  @Then("i should get status code {int}")
  public void i_should_get_status_code(Integer int1) {
    
    response
        .then()
        .statusCode(int1);
  }

}
