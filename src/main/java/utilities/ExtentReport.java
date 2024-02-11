package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport extends Utility {
	
	public static ExtentReports getExtentReport() {
		
	String path=System.getProperty("user.dir")+"\\reports\\extentreport.html";
	
	//create an object of extentspartreporter
	
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	
	//set the report name and document title
	
	reporter.config().setReportName("BestBuy Automation");
	reporter.config().setDocumentTitle("BestBuy Automation Test Result");
	
	//object of extentreports
	
	ExtentReports extent=new ExtentReports();
	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Krishnapriya");
	return extent;
}

}
