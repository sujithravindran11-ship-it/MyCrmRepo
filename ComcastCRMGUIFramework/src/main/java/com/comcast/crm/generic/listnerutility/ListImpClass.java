package com.comcast.crm.generic.listnerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclass.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ISuiteListener, ITestListener {

	public ExtentSparkReporter spark;
	public ExtentReports reports;

//	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==>" + result.getMethod().getMethodName());
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		String testname = result.getMethod().getMethodName();
		TakesScreenshot tc = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = tc.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		UtilityClassObject.getTest().addScreenCaptureFromBase64String(time);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

		// config of report
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CrmTestSuiteResults");
		spark.config().setReportName("CrmReport");
		spark.config().setTheme(Theme.DARK);

		// add env info and create test
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows-11");
		reports.setSystemInfo("Browser", "Chrome-141");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report Backup");
		reports.flush();
	}

}
