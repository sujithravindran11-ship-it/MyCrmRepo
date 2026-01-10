package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateorgwithIndustryType {

	public static void main(String[] args) throws Exception {

		// get utility objecct classes

		WebdriverUtility wlib = new WebdriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();

		// daata to be used
		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		String orgname = elib.getStringData("org", 7, 2) + jlib.getRandomNumber();
		String Industry=elib.getStringData("org", 4, 3);
		String Type=elib.getStringData("org", 4, 4);

		WebDriver driver = wlib.driverSelect(Browser);

		wlib.waitForPageLoad(driver);
		driver.get(Url);

		// loginusing valid credentials
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		// go to organisation and create new organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("ship_street")).sendKeys("a" + jlib.getRandomNumber());
		
		
		
		WebElement indusElement= driver.findElement(By.name("industry"));
		WebElement typeElement= driver.findElement(By.name("accounttype"));
		wlib.select(indusElement,Industry);
		wlib.select(typeElement, Type);
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verification of org name
		String actualorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (orgname.equals(actualorg)) {
			System.out.println(orgname + " has been created sucessfully");
		} else {

			System.out.println(orgname + " was not created sucessfully");
		}
		String actualIndus= driver.findElement(By.id("mouseArea_Industry")).getText();
		String actualType= driver.findElement(By.id("dtlview_Type")).getText();
//		System.out.println(actualIndus);
		if(actualIndus.equals(Industry)){
			System.out.println(Industry + " has been created sucessfully");
		}
		else {
			System.out.println(Industry + " not created sucessfully");
		}
		if(actualType.equals(Type)) {
			System.out.println(Type + " has been created sucessfully");
		}
		else {
			System.out.println(Type + " not created sucessfully");
		}
		
		driver.close();
	}
}
