package Utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepter {
	
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReprts() {
		
		String extentReportpath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		
		ExtentSparkReporter repoter = new ExtentSparkReporter(extentReportpath);
		repoter.config().setReportName("tuturialninjs Automstion Result");
		repoter.config().setDocumentTitle("Test Result");
		
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(repoter);
		extentReport.setSystemInfo("Opreting System","Windows 10");
		extentReport.setSystemInfo("Tested By","Fahed Arif");
		
		
		
		return extentReport;
		
		
	}

}
