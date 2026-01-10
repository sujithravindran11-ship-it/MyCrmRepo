package Objectrepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v129.page.model.NavigatedWithinDocument;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import ObjectRepository.CreatingNewOrgPage;
import ObjectRepository.Homepage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationPage;

public class ObjeRepo_CreateOrgTest {
	public static void main(String[] args) throws Exception {

		// get utility object classes

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
		String industry=elib.getStringData("org",4, 3);
		String shipping="a"+jlib.getRandomNumber();
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
		
		//creating new org
		CreatingNewOrgPage cnop =new CreatingNewOrgPage(driver);
		cnop.createOrg(orgname,shipping,industry);
		

		// Verification of org name
		String actualorg = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (orgname.equals(actualorg)) {
			System.out.println(orgname + " has been created sucessfully");
		} else {

			System.out.println(orgname + " was not created sucessfully");
		}
		
		// navigate back to organizations 
		hp.getOrganiztionLnk().click();
		
		//search with org name and select dropdown
		op.getSearchBox().sendKeys(orgname);
		wlib.select(op.getNamedropdown(), "Organization Name");
		op.getSearchBtn().click();
		Thread.sleep(3000);
		op.getCheckbox().click();
		op.getDeleteBtn().click();
		// logout
//		Actions act = new Actions(driver);
//		act.moveToElement(hp.getAdminImg()).perform();
//		hp.getSignoutBtn().click();
//		hp.logOutApp();
	}
}
