package Objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import ObjectRepository.CreateTroubleticketspage;
import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;
import ObjectRepository.Ticketinfopage;
import ObjectRepository.Troubleticketspage;

public class ObjRepo_CreateNewTicket {
	
	@Test
	public void CreateNewTicket() throws Exception{
		
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

				// enter login credentials
				LoginPage lp = new LoginPage(driver);
				lp.loginApp(Username,Password);


				//go to troubletickets
				Homepage hp = new Homepage(driver);
				hp.getTicketlnk().click();
				
				Troubleticketspage ttp= new Troubleticketspage(driver);
				ttp.getcreateticketbtn().click();
				//enter description
				CreateTroubleticketspage cttp= new CreateTroubleticketspage(driver);
				cttp.gettitleEdt().sendKeys("Url not Working");
				
				//priority
				WebElement priority= cttp.getPriority();
				wlib.select(priority, "Urgent");
				//severity
				WebElement severity= cttp.getSeverity();
				wlib.select(severity, "Critical");
				
				// status
				WebElement status= cttp.getStatus();
				wlib.select(status, "In Progress");
				
				cttp.getSavebtn().click();
				
				//get ticket no
				Ticketinfopage tip = new Ticketinfopage(driver);
				String tktno =tip.gettckno().getText().trim();
				System.out.println(tktno);
				

				
	}
	
}
