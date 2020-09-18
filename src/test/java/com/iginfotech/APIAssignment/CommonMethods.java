package com.iginfotech.APIAssignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class CommonMethods {

	static String endpointURL = "http://demo4032024.mockable.io/apitest";
	
	public static Response getResponse() {
		Response response = null;
		try {
			RestAssured.baseURI = endpointURL;
			response = RestAssured.given().contentType(ContentType.JSON).when().get();
		}
		catch(Exception e) {
			Assert.fail(e.getLocalizedMessage());
		}
		return response;
	}
}
