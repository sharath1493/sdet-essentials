package restassured;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_GetRequest {

	@Test
	public void getAPIRequest()
	{
		RestAssured.baseURI="https://reqres.in/api/users";

		// https://reqres.in/api/users?page=2

		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET, "/2");

		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusCode());
		
		SoftAssert sa= new SoftAssert();
		
		sa.assertEquals(response.getStatusCode(),201);
		
		System.out.println(response.getStatusLine());
		
		sa.assertEquals(response.getStatusLine(),"HTTP/1.1 201 OK");
		
		sa.assertAll();
	}

}
