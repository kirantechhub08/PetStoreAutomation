package api.endpoints;



import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserEndPoints {
	
	//create CRUD operation on user api
	
	
	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_URL);
		
		return response;
	}
	
	
	
	public static Response readUser(String uname)
	{
		Response response=given()
		.pathParam("username", uname)
		.when()
		.get(Routes.get_URL);
		
		return response;
		
	}
	
	
	public static Response updateUser(User payload, String uname)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", uname)
		.body(payload)
		.when()
		.post(Routes.put_URL);
		
		return response;
	}
	
	
	public static Response delete(String uname)
	{
		Response response=given()
		.pathParam("username", uname)
		.when()
		.get(Routes.delete_URL);
		
		return response;
		
	}

}
