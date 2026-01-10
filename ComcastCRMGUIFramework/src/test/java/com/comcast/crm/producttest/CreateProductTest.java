package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateProductTest {

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
				String product= elib.getStringData("product", 0, 0)+ jlib.getRandomNumber();
				System.out.println(product);
				
				
				WebDriver driver = wlib.driverSelect(Browser);

				wlib.waitForPageLoad(driver);
				driver.get(Url);
				
				// loginusing valid credentials
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(Password);
				driver.findElement(By.id("submitButton")).click();
				
				// go to productslnk  and create new product
				driver.findElement(By.linkText("Products")).click();
				
				//create new product and save
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(product);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actualprod = driver.findElement(By.className("lvtHeaderText")).getText();
				System.out.println(actualprod);
				if (actualprod.contains(product)) {
					System.out.println(product + " has been created sucessfully");
				} else {

					System.out.println(product + " was not created sucessfully");
				}
				
				//driver.close();
				
				

	}

}
