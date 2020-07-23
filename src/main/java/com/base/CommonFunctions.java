package com.base;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonFunctions extends TestBase{
	static RequestSpecification httpRequest;
	Response httpResponse=null;
	
	public Response parseJsonPath() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		log("Base URL :"+RestAssured.baseURI);
		// Request Object
		httpRequest=RestAssured.given();
		log("HTTP request created");
		log("Base URI :"+RestAssured.baseURI+"");
		 httpResponse = httpRequest.request(Method.GET,"");
		log("HTTP response created");
		 System.out.println("Response :" + httpResponse.asString());
	        System.out.println("Status Code :" + httpResponse.getStatusCode());
	        return httpResponse;		
	}
	
	
	public Response getResponseWithQueryParams() {
		 RestAssured.baseURI = "https://reqres.in/api";
	        RequestSpecification request = RestAssured.given();
	        Map<String, String> queryParams = new HashMap<String, String>();
	        queryParams.put("id", "5");
	        queryParams.put("page", "2");
	        httpResponse=request.queryParameters(queryParams).get("/users");
	        return httpResponse;		
	}
	
	public Response getResponseWithPathParams() {
		   String id = "1";
	        RestAssured.baseURI = "https://reqres.in/api/users";
	        RequestSpecification request = RestAssured.given();
	        Map<String, String> pathParams = new HashMap<String, String>();
	        pathParams.put("id", id);
	        Response httpResponse =request.pathParameters(pathParams).get("/{id}");
	        return httpResponse;		
	}
}
