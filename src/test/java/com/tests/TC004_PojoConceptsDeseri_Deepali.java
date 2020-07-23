package com.tests;

import org.testng.annotations.Test;

import com.config.ReadPropertyFile;

import io.restassured.RestAssured;
import pojo.PojoClass1;

public class TC004_PojoConceptsDeseri_Deepali {
	@Test
    public void testDeSerialization() {
 
		  RestAssured.baseURI=ReadPropertyFile.get("urlDeepali");

        PojoClass1 pojo = RestAssured.get("https://reqres.in/api/users/1").as(PojoClass1.class);
 
        System.out.println(pojo.toString());
    }
 
}
