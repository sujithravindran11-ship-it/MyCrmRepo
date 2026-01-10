package com.comcast.crm.troubleticket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class CreateNewTicket {
	
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


				//go to troubletickets
				driver.findElement(By.linkText("Trouble Tickets")).click();
				driver.findElement(By.xpath("//img[@title='Create Ticket...']")).click();
				//enter description
				driver.findElement(By.name("ticket_title")).sendKeys("Url not Working");
				
				//priority
				WebElement priority= driver.findElement(By.name("ticketpriorities"));
				wlib.select(priority, "Urgent");
				//severity
				WebElement severity= driver.findElement(By.name("ticketseverities"));
				wlib.select(severity, "Critical");
				
				// status
				WebElement status= driver.findElement(By.name("ticketstatus"));
				wlib.select(status, "In Progress");
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//get ticket no
				String tktno =driver.findElement(By.xpath("//div[@id='tblTicketInformation']/table/tbody/tr[7]/td[2]")).getText();
				System.out.println(tktno);
				

				
	}
	
}
