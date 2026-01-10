package Objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v129.domsnapshot.model.RareBooleanData;
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

public class ObjRepo_CreateOrgwithPhno {

	@Test
	public void CreateorgwithIndustryType() throws Throwable {

		WebdriverUtility wlib = new WebdriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();

		// daata to be used
		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		String shipping = elib.getStringData("product", 1, 0);
		String orgname = elib.getStringData("org", 7, 2) + jlib.getRandomNumber();
		String phno= elib.getStringData("org", 7, 3);
		
		WebDriver driver = wlib.driverSelect(Browser);

		wlib.waitForPageLoad(driver);
		driver.get(Url);

		// loginusing valid credentials
		// enter login credentials
		LoginPage lp = new LoginPage(driver);
		lp.loginApp("admin", "admin");

		// go to organisation and create new organization
		Homepage hp = new Homepage(driver);
		hp.getOrganiztionLnk().click();

		// go to organisation
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganiztionLnk().click();

		// creating new org
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgname);
		cnop.getOrgshipingEdt().sendKeys(shipping);
		cnop.getOrgPhno().sendKeys(phno);
		cnop.getSaveBtn().click();
		
		// Verification of org name
		String actualorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		boolean status = actualorg.contains(orgname);
		Assert.assertEquals(status, true);
		System.out.println(orgname + " has been created sucessfully");

		String actualPhno = driver.findElement(By.id("mouseArea_Phone")).getText().trim();
		System.out.println(actualPhno);
		boolean statusphno=actualPhno.equals(phno);
		//boolean statusind = actualIndus.equals(Industry);
		Assert.assertEquals(statusphno, true);
		System.out.println(phno + " has been created sucessfully");

		driver.close();
	}
}
