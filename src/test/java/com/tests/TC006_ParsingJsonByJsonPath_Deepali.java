package com.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.CommonFunctions;
import com.base.TestBase;
import com.config.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC006_ParsingJsonByJsonPath_Deepali extends CommonFunctions {
	
	@Test
		public void getReq() {
			
		       
		        CommonFunctions cm=new CommonFunctions();
		        
		        String s=  cm.parseJsonPath().getBody().asString();
		        JsonPath jpath=cm.parseJsonPath().jsonPath();
		        System.out.println("ID :- " + jpath.get("id"));
		        String emailList = jpath.getString("email");
		        System.out.println("Email "+emailList);
		        
		        List<String> jsonResponse = jpath.getList("$");
		        System.out.println("jsonResponse.size: "+jsonResponse.size());
		        String usernames = jpath.getString("username[0]");

		        System.out.println("username[0] : "+usernames);
		        List<Map<String, String>> companies = jpath.getList("company");
		        System.out.println("Company Details: "+companies.get(0).get("name"));
		        
		        
		        List<Map<String, String>> address = jpath.getList("address");
		        System.out.println("Address Details: "+address.get(0).get("street"));
		        

	
	}
}
