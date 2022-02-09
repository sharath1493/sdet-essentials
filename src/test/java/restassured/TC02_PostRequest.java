package restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_PostRequest {

	@Test
	public void postAPIRequest()
	{
		//Base URI
		RestAssured.baseURI="https://reqres.in/api/users";

		//Request
		RequestSpecification req = RestAssured.given();

		//Request Headers
		req.headers("Content-Type", "application/json");


		//Request PayLoad
		JSONObject j = new JSONObject();
		j.put("name", "Pamela");
		j.put("job", "Life Guard");

		req.body(j.toJSONString());

		//Response
		Response res = req.request(Method.POST);

		System.out.println(res.getBody().asString());

		SoftAssert sa= new SoftAssert();

		sa.assertEquals(res.getStatusCode(), 201);
		sa.assertEquals(res.getStatusLine(), "HTTP/1.1 201 Created");

		
		
		//Read Response data
		//System.out.println(res.jsonPath().get("name"));
		//System.out.println(res.jsonPath().get("id"));


		sa.assertAll();
	}

}
