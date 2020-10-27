package RestAssured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ApiTestCase {
  @Test
  public void f() {
	  Response response;
	  response=RestAssured.get("https://api.genderize.io/?name=john");
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is :"+responseBody);
  }
}
