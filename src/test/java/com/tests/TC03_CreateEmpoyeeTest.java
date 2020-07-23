package com.tests;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.base.RandomString;
import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC03_CreateEmpoyeeTest extends TestBase {

	
	@Test(priority=2)
	public void responseTest() {
	
		//String Payload= "{\\r\\n\\t\\t\\\"employee_name\\\":\\\"Madhur\\\",\\r\\n\\t\\t\\\"employee_salary\\\":\\\"50000\\\",\\r\\n\\t\\t\\\"employee_age\\\":\\\"27\\\"\\r\\n\\t\\t\\r\\n\\t}";
		log("Response :"+postResponse("create").getBody().asString());	
		
		
		
	
	}
	

	


}
