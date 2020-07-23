package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;


public class TC02_SingleEmployeeGetTest extends TestBase {
	
	@Test(priority=1)
	public void statusCodeTest() {
		int res = getResponse("employee/60260").getStatusCode();
		log("Status Code :"+res);
		Assert.assertEquals(res, 200);
		System.out.println("ThreadNo: "+Thread.currentThread().getId());
		
	}
	
	@Test(priority=2)
	public void responseTest() {
	
		log("Response :"+getResponse("employee/60292").getBody().asString());	
		System.out.println("ThreadNo: "+Thread.currentThread().getId());

	}
	
	@Test(priority=3)
	public void statusLineTest()
	{
	
		log("Status Line :"+getResponse("employee/60260").getStatusLine());	
		System.out.println("ThreadNo: "+Thread.currentThread().getId());

	}
	
	@Test(priority=4)
	public void contentTypeTest() {
	
		log("Content Type :"+getResponse("employee/60260").getContentType());	
		System.out.println("ThreadNo: "+Thread.currentThread().getId());

	}
	
	@Test(priority=5)
	public void headersTest() {
	
		log("Headers :"+getResponse("employee/60260").getHeaders());	
		System.out.println("ThreadNo: "+Thread.currentThread().getId());

	}

	


}
