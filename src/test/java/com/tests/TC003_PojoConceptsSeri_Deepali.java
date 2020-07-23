package com.tests;

import static org.testng.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.config.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PojoClass1;

public class TC003_PojoConceptsSeri_Deepali extends TestBase{
	RequestSpecification httpRequest;

  @Test(enabled =false)
  public void postRequestNormal() {
	  
		RestAssured.baseURI=ReadPropertyFile.get("urlDeepali");
		httpRequest=RestAssured.given();
		log("HTTP request created");
		JSONObject requestParam = new JSONObject();
		requestParam.put("email", "eve.holt@reqres.in");
		requestParam.put("password", "pistol");
		httpRequest.header("Content-Type","application/json");					
		httpRequest.body(requestParam.toJSONString());				
		log("Base URI :"+RestAssured.baseURI+"register");
		Response httpResponse = httpRequest.request(Method.POST,"register");
		log("HTTP response created");
		System.out.println("Resopnse is: "+ httpResponse.getBody().asString());
		log("Base URL :"+RestAssured.baseURI);
		
  }
  
   
  
  @Test(enabled =false)
  public void testSerializationBDD() {

      Response response = null;

      PojoClass1 pojo = new PojoClass1("eve.holt@reqres.in", "pistol");

      response = RestAssured.given()
          .contentType("application/json")
          .body(pojo)
          .when()
          .post("https://reqres.in/api/register");

      pojo.toString();
	  System.out.println("1 :"+pojo.getEmail());
	  System.out.println("2 :"+pojo.getPassword());
	  System.out.println("3 :"+pojo.toString());

  }
  
  
  
  @Test(enabled =true)
  public void testSerializationNormal() {

      PojoClass1 pojo = new PojoClass1("eve.holt@reqres.in", "pistol");

	  RestAssured.baseURI=ReadPropertyFile.get("urlDeepali");
		httpRequest=RestAssured.given();
		log("HTTP request created");

		httpRequest.header("Content-Type","application/json");					
		httpRequest.body(pojo);				
		log("Base URI :"+RestAssured.baseURI+"register");
		Response httpResponse = httpRequest.request(Method.POST,"register");
		log("HTTP response created");
		System.out.println("Resopnse is: "+ httpResponse.getBody().asString());
		log("Base URL :"+RestAssured.baseURI);
		  System.out.println("1 :"+pojo.getEmail());
		  System.out.println("2 :"+pojo.getPassword());
		  System.out.println("3 :"+pojo.toString());
  }

}
