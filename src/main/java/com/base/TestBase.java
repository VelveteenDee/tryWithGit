package com.base;


import org.json.simple.JSONObject;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.config.ReadPropertyFile;
import com.reportconfig.ExtentReport;
import com.utility.Log;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase 
{
	public ITestResult result;
	public static ExtentTest logger;
	RequestSpecification httpRequest;
	String name="Deepali";
    public static RequestSpecification Request;

	static {
		ExtentReport.initialize();
	}
	
	
	public RequestSpecification request() {

		if(name=="Deepali")
		{
			RestAssured.baseURI=ReadPropertyFile.get("urlDeepali");
	
		}
		else 
		{
			RestAssured.baseURI=ReadPropertyFile.get("url");

		}
			
		log("Base URL :"+RestAssured.baseURI);
		// Request Object
		httpRequest=RestAssured.given();
		log("HTTP request created");
		
		return httpRequest;
	}
	
	public Response getResponse(String value) {
		log("Base URI :"+RestAssured.baseURI+value);
		Response httpResponse = httpRequest.request(Method.GET,value);
		log("HTTP response created");
		return httpResponse;
		
	}
	
	@SuppressWarnings("unchecked")
	public Response postResponse(String Value) {
		//Request Payload
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", RandomString.getAlphaNumericString(5));
		requestParam.put("salary", "6");
		requestParam.put("age", "26");				
		httpRequest.header("Content-Type","application/json");					
		httpRequest.body(requestParam.toJSONString());				
		log("Base URI :"+RestAssured.baseURI+Value);
		Response httpResponse = httpRequest.request(Method.POST,Value);
		log("HTTP response created");
		return httpResponse;
		
	}
	
	public Response queryParamostResponse(String Value) {
		//Request Payload
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "morpheus");
		requestParam.put("job", "leader");
		httpRequest.header("Content-Type","application/json");					
		httpRequest.body(requestParam.toJSONString());				
		log("Base URI :"+RestAssured.baseURI+Value);
		Response httpResponse = httpRequest.request(Method.POST,Value);
		log("HTTP response created");
		return httpResponse;
		
	}
	
	@SuppressWarnings("unchecked")
	public Response putResponse(String Value) {
		httpRequest.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put("salary", "700");
		json.put("name", "madhur bharadwaj");
		json.put("age", "26");	
		httpRequest.body(json.toJSONString());		
		log("Base URI :"+RestAssured.baseURI+Value);
		Response httpResponse = httpRequest.request(Method.PUT,Value);
		log("HTTP response created");
		return httpResponse;
		
	}
	
	@SuppressWarnings("unchecked")
	public Response deleteResponse(String Value) {
		log("Base URI :"+RestAssured.baseURI+Value);
		Response httpResponse = httpRequest.request(Method.DELETE,Value);
		log("HTTP response created");
		return httpResponse;
		
	}
	
	
	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test Case Pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Test Case Skiped");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Case Failed");
		} 
	}
    
	@BeforeMethod
	public void setUp(java.lang.reflect.Method result) {
		logger= ExtentReport.extent.createTest(result.getName());
		Log.startTestCase(result.getName());
		log("Test Case Started");
		request();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		log("Test Case Ended");
		getresult(result);
		ExtentReport.extent.flush();
		
	}
	
	public static void log(String data) {
		Log.info(data);
		Reporter.log(data);
		logger.log(Status.INFO, data);
		
	}
	
	
}
