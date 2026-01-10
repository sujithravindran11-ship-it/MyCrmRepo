package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithOrgTestIT {

	public static void main(String[] args) throws Throwable{
		
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
				String lastN=  "a"+ jlib.getRandomNumber();
				
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
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actualorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
				if (orgname.equals(actualorg)) {
					System.out.println(orgname + " has been created sucessfully");
				} else {

					System.out.println(orgname + " was not created sucessfully");
				}
				
				//Thread.sleep(5000);
				//wlib.waitForElementPresent(driver, xElement);
				//click on contact link
				WebElement xElement = driver.findElement(By.linkText("Contacts"));
				xElement.click();
				
				// click on create contact img
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//provide the last name
				driver.findElement(By.name("lastname")).sendKeys(lastN);
				
				//select organization  which was created
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
				wlib.switchToTabOnUrl(driver,"module=Accounts");
				driver.findElement(By.id("search_txt")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(orgname)).click();
				wlib.switchToTabOnUrl(driver, "module=Contacts");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String actuallastN = driver.findElement(By.id("dtlview_Last Name")).getText();
				if (lastN.equals(actuallastN)) {
					System.out.println(lastN + " has been created sucessfully");
				} else {

					System.out.println(lastN + " was not created sucessfully");
				}
				
				driver.close();
		
	}
}
