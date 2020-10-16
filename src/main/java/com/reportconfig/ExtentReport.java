package com.reportconfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport 
{
	public static ExtentHtmlReporter reporter=null;
	public static ExtentReports extent=null;

	//private constructor to limit initialization to one
	private ExtentReport()
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
	//	reporter=new ExtentHtmlReporter("./Reports/Report_"+ formater.format(calendar.getTime())+ ".html");
		reporter=new ExtentHtmlReporter("./Reports/Report.html");
	//hi my name ifs git 
		reporter.config().setDocumentTitle("RestAssured Automation Report");
		reporter.config().setReportName("RestAssured Execution");
		
		
        // Create object of ExtentReports class- This is main class which will create report
		extent = new ExtentReports();
		extent.setSystemInfo("Environment", "Automation");
		extent.setSystemInfo("Created By", "Deepali Akolkar");
    
        // attach the reporter which we created in Step 1
		extent.attachReporter(reporter);
		
	    // call createTest method and pass the name of TestCase- Based on your requirement
	    
	    
            // log method will add logs in report and provide the log steps which will come in report
	   
		
	
	}
	//Initializes Report
	public static void initialize()
	{
		ExtentReport report=new ExtentReport();
	}
}
