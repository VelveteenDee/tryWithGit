package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.config.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_AuthRequest_Deepali extends TestBase {
 
	RequestSpecification httpRequest;
@Test(enabled=false)
	public void getReqAccessDenied() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		log("Base URL :"+RestAssured.baseURI);
		httpRequest=RestAssured.given();
		log("HTTP request created");
		log("Base URI :"+RestAssured.baseURI+"");
		Response httpResponse = httpRequest.request(Method.GET,"");
		log("HTTP response created");
		System.out.println("Auth Response is: "+httpResponse.getBody().asString());
		
	}

@Test(enabled=false)
public void getRequestAccessAuthorised() {
	
	RestAssured.baseURI="http://restapi.demoqa.com/authentication";
	log("Base URL :"+RestAssured.baseURI);
	httpRequest=RestAssured.given();
	


    Map<String, String> queryParams = new HashMap<String, String>();
    queryParams.put("Username", "ToolsQA");
    queryParams.put("Password", "TestPassword");

    @SuppressWarnings("deprecation")
	Response response =httpRequest.queryParameters(queryParams).get("/CheckForAuthentication");
    String getRes=response.getBody().asString();
    System.out.println("Response body :"+ getRes);
    System.out.println("Status Code: "+response.getStatusCode()); 	


}


@Test(enabled=true)
public void basicAuthenticationTest() {

    RestAssured.baseURI = "http://restapi.demoqa.com/authentication";

    Response response = null;

   
    String invalidusername = "ToolsQAInvalid";
    String invalidpassword = "TestPasswordInvalid";

    String validusername = "ToolsQA";
    String validpassword = "TestPassword";


    //Scenario with incorrect username & password
response = RestAssured.given()
        .auth().basic(invalidusername, invalidpassword)
        .when()
        .get("/CheckForAuthentication");

  System.out.println("Access Unauthorized \nStatus Code :" + response.getStatusCode());
    System.out.println("Response :" + response.asString());

    System.out.println("\n---------------------------------------------------\n");

    //Scenario with correct username & password	
    response = RestAssured.given()
        .auth().basic(validusername, validpassword)
        .when()
        .get("/CheckForAuthentication");

    System.out.println("Access Authorized \nStatus Code :--" + response.getStatusCode());
    System.out.println("Response :--" + response.asString());
}
}
