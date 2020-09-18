package com.iginfotech.APIAssignment;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APIAssignmnet extends CommonMethods {
	
	Response response = CommonMethods.getResponse();
	
	@Test
	public void Test1() {
		try {
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
		}
		catch(Exception e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void Test2() {
		try {
			String responseHeader = response.getHeader("Content-Type");
			Assert.assertEquals(responseHeader, "application/json; charset=UTF-8");
		}
		catch(Exception e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void Test3() {
		try {
			String responseValue = response.asString();
			JSONObject jsonObject = new JSONObject(responseValue);
			JSONObject jsonObj = jsonObject.getJSONArray("employeeData").getJSONObject(0);
			Assert.assertEquals(jsonObject.get("status"), 200);
			Assert.assertEquals(jsonObj.getInt("age"), 25);
			Assert.assertEquals(jsonObj.getString("role"), "QA Automation Developer");
			Assert.assertEquals(jsonObj.getString("dob"), "25-02-1994");
			Assert.assertEquals(jsonObject.get("message"), "data retrieved successful");	
		}
		catch(Exception e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void Test4() {
		try {
			String responseValue = response.asString();
			JSONObject jsonObject = new JSONObject(responseValue);
			Assert.assertEquals(jsonObject.getJSONArray("employeeData").getJSONObject(0).get("company"), "ABC Infotech");
		}
		catch(Exception e) {
			Assert.fail(e.getLocalizedMessage());
		}
	}

}
