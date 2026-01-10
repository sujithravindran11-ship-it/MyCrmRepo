package com.comcast.crm.troubleticket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class Practiceedittest {
	
	public static void main(String[] args) throws Exception{
		
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
				
				WebDriver driver = wlib.driverSelect(Browser);

				wlib.waitForPageLoad(driver);
				driver.get(Url);

				// loginusing valid credentials
				driver.findElement(By.name("user_name")).sendKeys(Username);
				driver.findElement(By.name("user_password")).sendKeys(Password);
				driver.findElement(By.id("submitButton")).click();
				
				//trouble ticket
				
				driver.findElement(By.linkText("Trouble Tickets")).click();
				driver.findElement(By.name("search_text")).sendKeys("TT632");

				driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
				driver.findElement(By.linkText("edit")).click();
				WebElement statusre= driver.findElement(By.name("ticketstatus"));
				wlib.waitForElementPresent(driver, statusre);
				Thread.sleep(2000);
				
				Select select=new Select(statusre);
				select.selectByIndex(3);
//				wlib.select(statusre, "Closed");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				Thread.sleep(2000);
//				driver.quit();
				

	}
}
