package Objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import ObjectRepository.CreateLeadsPage;
import ObjectRepository.Homepage;
import ObjectRepository.LeadsPage;
import ObjectRepository.LoginPage;

public class ObjRepo_CreateLeads {

	@Test
	public void CreateLeads() throws Exception {
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wlib = new WebdriverUtility();
		ExcelUtility elib = new ExcelUtility();

		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");

		// testscript
		String lastname = elib.getStringData("leads", 0, 0) + jlib.getRandomNumber();
		String company = elib.getStringData("leads", 1, 0) + jlib.getRandomNumber();

		WebDriver driver = wlib.driverSelect(browser);
		wlib.waitForPageLoad(driver);
		driver.get(url);

		// enter login credentials
		LoginPage lp = new LoginPage(driver);
		lp.loginApp("admin", "admin");

		// navigate to leads
		Homepage hp = new Homepage(driver);
		hp.getLeadlnk().click();

		// click on creat lead
		LeadsPage llp = new LeadsPage(driver);
		llp.getleadcreatebtn().click();

		// enter last name
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		clp.getLastNameEdt().sendKeys(lastname);
		// enter company
		clp.getcompanyEdt().sendKeys(company);

		// save
		clp.getSaveBtn().click();

		// verify headerinfo last name and company
		String lastnameprint = driver.findElement(By.id("dtlview_Last Name")).getText();
		boolean lastcheck = lastnameprint.contains(lastname);
		Assert.assertEquals(lastcheck, true);
		System.out.println(lastname + "is created == PASS");

		String compnayprint = driver.findElement(By.id("dtlview_Company")).getText();
		boolean companycheck = compnayprint.contains(company);
		Assert.assertEquals(companycheck, true);
		System.out.println(company + "is created == PASS");

		System.out.println(lastnameprint);
		System.out.println(compnayprint);

		driver.quit();
	}
}
