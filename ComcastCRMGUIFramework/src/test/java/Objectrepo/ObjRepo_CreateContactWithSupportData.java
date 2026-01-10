package Objectrepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import ObjectRepository.Contactpage;
import ObjectRepository.Createcontactpage;
import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;

public class ObjRepo_CreateContactWithSupportData {

	@Test
	public void CreateContactWithSupportData() throws IOException, Throwable {
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebdriverUtility wlib = new WebdriverUtility();
		ExcelUtility elib = new ExcelUtility();

		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");

		WebDriver driver = wlib.driverSelect(browser);
		wlib.waitForPageLoad(driver);
		driver.get(url);

		String lastname = elib.getStringData("contact", 7, 3) + jlib.getRandomNumber();

		// enter login credentials
		LoginPage lp = new LoginPage(driver);
		lp.loginApp("admin", "admin");

		// click on contact link
		Homepage hp = new Homepage(driver);
		hp.getContactlnk().click();

		// click on create contact img
		Contactpage cp = new Contactpage(driver);
		cp.getConcreatebtn().click();

		// provide the last name
		Createcontactpage ccp = new Createcontactpage(driver);
		ccp.getContactLastNedt().sendKeys(lastname);

		String startdate = jlib.getSystemDate();
		String enddate = jlib.getRequiredDateYYYYMMDD(30);

		ccp.getContactSupprtStrtDateEdt().clear();
		ccp.getContactSupprtStrtDateEdt().sendKeys(startdate);
		ccp.getContactSupprtEndDateEdt().clear();
		ccp.getContactSupprtEndDateEdt().sendKeys(enddate);
		System.out.println(enddate);
		// save
		ccp.getContactSavebtn().click();
		System.out.println("saved");
		// verify headerinfo with industry and type

		Thread.sleep(3000);
		String startdateprint = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		boolean startdatecheck = startdateprint.contains(startdate);
		Assert.assertEquals(startdatecheck, true);
		System.out.println(startdate + " is created == PASS");

		String reqdateprint = driver.findElement(By.id("dtlview_Support End Date")).getText();
		boolean enddatecheck = reqdateprint.contains(enddate);
		Assert.assertEquals(enddatecheck, true);
		System.out.println(enddate + " is created == PASS");

		driver.quit();

	}
}
