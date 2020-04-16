package luxgood.restapi;

import org.testng.annotations.BeforeSuite;
import io.restassured.RestAssured;

public class BaseAPITest {

    private static final String BASE_URI = "http://dummy.restapiexample.com/";
    private static final String BASE_PATH = "api/v1";

    @BeforeSuite
    public void prepare() {
	RestAssured.baseURI = BASE_URI;
	RestAssured.basePath = BASE_PATH;
	
	
	
    }

}
