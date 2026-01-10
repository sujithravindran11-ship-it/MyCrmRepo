package Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;


public class SampleTestwithPom {
	
	@FindBy(name = "user_name")
	WebElement ele1;
	
	@FindBy(name = "user_password")
	WebElement ele2;
	
	@FindBy(id = "submitButton")
	WebElement ele3;
	
	@Test
	public void sampleTest() throws Exception {
		
		WebdriverUtility wlib= new WebdriverUtility();
		
		WebDriver driver =wlib.driverSelect("chrome");
		driver.get("http://49.249.28.218:8888/");
		
		SampleTestwithPom s = PageFactory.initElements(driver,SampleTestwithPom.class);
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		driver.navigate().refresh();
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		s.ele3.click();
		

		
	}
}
