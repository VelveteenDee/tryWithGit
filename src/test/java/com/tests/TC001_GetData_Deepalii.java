package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.RandomString;
import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetData_Deepalii extends TestBase {
    public static RequestSpecification Request;

  //@Test
	public void getReq() {
		int res=getResponse("/1").getStatusCode();
		log("Status Code :"+res);
		Assert.assertEquals(res, 200);
	}
  
  @Test
  public void postreq()
  {
  }
}
