package luxgood.restapi;


import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;

public class EmployeeService implements EmpService {

  // private static Cookie cookie;
  private static Map<String, String> cookies = new HashMap<String, String>();



  public Response createEmployee(Employee employee) {
    Response response = given()
        .body(employee)
        .when()
        .post("/create");

    cookies = response
        .getCookies();

    return response;
  }

  public Response getEmployee(Integer employeeId) {
    Response response = given()
        .cookies(cookies)
        .pathParam("employee_id", employeeId)
        .when()
        .get("/employee/{employee_id}");



    return response;
  }

  public Response getEmployees() {
    Response response = given()
        .cookies(cookies)
        .when()
        .get("/employees");

    return response;
  }


  public Response updateEmployee(Integer id, Employee emp) {
    Response response = given()
        .body(emp)
        .pathParam("employee_id", id)
        .cookies(cookies)
        .when()
        .put("/update/{employee_id}");

    return response;
  }

}
