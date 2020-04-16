package luxgood.restapi;

import io.restassured.response.Response;

public interface EmpService {

  public Response createEmployee(Employee employee);

  public Response getEmployee(Integer employeeId);

  public Response getEmployees();

  public Response updateEmployee(Integer id, Employee emp);

}
