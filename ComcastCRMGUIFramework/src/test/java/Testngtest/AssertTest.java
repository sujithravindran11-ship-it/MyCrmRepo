package Testngtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import ObjectRepository.CreatingNewOrgPage;
import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;

public class AssertTest {
	@Test
	public void CreateOrgTest() throws Throwable {
		WebdriverUtility wlib = new WebdriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();

		// data to be used
		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		String orgname = elib.getStringData("org", 7, 2) + jlib.getRandomNumber();
		String industry = elib.getStringData("org", 4, 3);
		String shipping = "a" + jlib.getRandomNumber();
		WebDriver driver = wlib.driverSelect(Browser);

		wlib.waitForPageLoad(driver);
		driver.get(Url);
		// enter login credentials
		LoginPage lp = new LoginPage(driver);
		lp.loginApp("admin", "admin");

		// click on organizations link
		Homepage hp = new Homepage(driver);
		hp.getOrganiztionLnk().click();

		// go to organisation
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganiztionLnk().click();

		// creating new org
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrg(orgname, shipping, industry);

		// Verification of org name
		String actualorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		boolean status = actualorg.contains(orgname);
		Assert.assertEquals(status, true);
		System.out.println(orgname + " has been created sucessfully");
//		System.out.println(orgname + " was not created sucessfully");
	}
	
	
}
