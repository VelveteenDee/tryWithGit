package com.tests;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.CommonFunctions;
import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PojoClass1;

public class TC002_SchemaValidation_Deepali extends TestBase {
    Response httpResponse;
/*
 * Get Data and compare data from JSON File and GeT Response
 *  */
    CommonFunctions cm=new CommonFunctions();
    @Test(enabled=false)
	public void testJsonSchemaBdd()
	{
     RestAssured.given()
          .when()
          .get("https://reqres.in/api/users/1")
          .then()
          .assertThat()
          .body(matchesJsonSchemaInClasspath("JsonSchemaFile.json"));
  
	}
    
    
    /*
     * Get Data and compare data from JSON File and GeT Response
     *  */
    @Test(enabled=false)
    public void testJsonSchemaNormal() {
    	
	String str=getResponse("/1").getBody().asString();
	System.out.println("|| "+  matchesJsonSchemaInClasspath("JsonSchemaFile.json"));
	assertThat(str, matchesJsonSchemaInClasspath("JsonSchemaFile.json"));
    }
	
    
    /*
     * Get Data with adding query  params
     *  */
@Test(enabled=false)
public void queryParameterBDD() {

RestAssured.baseURI ="https://reqres.in/api"; 
RequestSpecification request = RestAssured.given();
Response response = request.queryParam("page", "2")
                 .queryParam("id", 5) 
                 .get("/users");

String jsonString = response.asString();
System.out.println("Json Response is: "+jsonString);
System.out.println(response.getStatusCode()); 
Assert.assertEquals(jsonString.contains("charles"), true);

}


/*
 * Get Data with adding query  params
 *  */

@SuppressWarnings("deprecation")
@Test(enabled=false)
 public void queryParameterNormal() {
	       

    String s=  cm.getResponseWithQueryParams().getBody().asString();

    httpResponse=cm.getResponseWithQueryParams();
	        System.out.println("Response body :"+ s);
	        System.out.println("Status Code: "+httpResponse.getStatusCode());
	    }
	 

/*
 * Get Data with adding path  params
 *  */
@SuppressWarnings("deprecation")
@Test(enabled=true)
 public void pathParameterNormal() {
	httpResponse=cm.getResponseWithPathParams();
	        String getRes=httpResponse.getBody().asString();
	        System.out.println("Response body :"+ getRes);
	        System.out.println("Status Code: "+httpResponse.getStatusCode());
	    }
	
	

/*
 * Get Data with adding path  params
 *  */
 @Test(enabled=false)
 public void pathParameterBDD() {

     String id = "1";
     RestAssured.baseURI = "https://reqres.in/api/users";
     Response response = null;
     try {
         response = RestAssured.given()
                               .pathParam("id", id)
                               .when()
                               .get("/{id}");
     } catch (Exception e) {
         e.printStackTrace();
     }
     
     PojoClass1[] pojo = response.getBody().as(PojoClass1[].class);

System.out.println(pojo[0].getEmail());
System.out.println(pojo[1].getEmail());
System.out.println(pojo[1].getPassword());
System.out.println(pojo[0].getPassword());


     System.out.println("Response :" + response.asString());
     System.out.println("Status Code :" + response.getStatusCode());

     assertEquals(200, response.getStatusCode());
 }
 @Test(enabled=false)
 public void getResponseInPOJO() {

     String id = "1";

     RestAssured.baseURI = "https://reqres.in/api/users";

     Response response = null;

     try {
         response = RestAssured.given()
                               .pathParam("id", id)
                               .when()
                               .get("/{id}");
     } catch (Exception e) {
         e.printStackTrace();
     }
     System.out.println("Response :" + response.asString());
     System.out.println("Status Code :" + response.getStatusCode());

     assertEquals(200, response.getStatusCode());
 }
	
}
