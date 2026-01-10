package com.comcast.crm.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;

public class Baseclass {

	// create object
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	WebdriverUtility wlib = new WebdriverUtility();
	ExcelUtility elib = new ExcelUtility();

	WebDriver driver = null;
	public static WebDriver sdriver;

	@BeforeSuite
	public void configBS() {
		System.out.println("==connect db , Report config");

	}

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("==launch browser==");
		String browser = flib.getDataFromPropertiesFile("browser");

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equals("edge")) {

			driver = new EdgeDriver();
			driver.manage().window().maximize();

		} else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}

		sdriver = driver;
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===Login===");

		String Url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginApp(username, password);

	}

	@AfterMethod
	public void configAM() throws IOException {
		Homepage hp = new Homepage(driver);
		hp.logOutApp();
	}

	@AfterClass
	public void configureAC() {
		driver.quit();
	}

	@AfterSuite
	public void configureAS() {
		System.out.println("DB close, report backup");
	}

}