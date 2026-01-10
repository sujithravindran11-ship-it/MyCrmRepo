package Practice_Test;



import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class DemoblazeTask2_60127 {
	
	@Test
	public void monitors() throws Exception {
		
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		WebdriverUtility wlib= new WebdriverUtility();
		
		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("taskurl");
		
		//test data
		String Name =elib.getStringData("Placeorderdetails", 0, 1);
		String Coutry =elib.getStringData("Placeorderdetails", 1, 1);
		String City =elib.getStringData("Placeorderdetails", 2, 1);
		String Credcard =elib.getStringData("Placeorderdetails", 3, 1);
		String Month =elib.getStringData("Placeorderdetails", 4, 1);
		String Year =elib.getStringData("Placeorderdetails", 5, 1);
		
		WebDriver driver= wlib.driverSelect(browser);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		
		driver.findElement(By.linkText("Phones")).click();
		
		driver.findElement(By.xpath("(//a[@class='hrefch'])[position()=2]")).click();
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(2000);
		wlib.alertToAccept(driver);
		driver.findElement(By.linkText("Cart")).click();
		
		TakesScreenshot scsearch= (TakesScreenshot)driver;
		
		File src = scsearch.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshots/Cartpage.png");
		FileHandler.copy(src, dest);
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement wname=driver.findElement(By.id("name"));
		wlib.waitForElementPresent(driver, wname);
		wname.sendKeys(Name);
		driver.findElement(By.id("country")).sendKeys(Coutry);
		driver.findElement(By.id("city")).sendKeys(City);
		WebElement wcred= driver.findElement(By.id("card"));
		wlib.waitForElementPresent(driver, wcred);
		wcred.sendKeys(Credcard);
		driver.findElement(By.id("month")).sendKeys(Month);
		driver.findElement(By.id("year")).sendKeys(Year);	
		
		
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		
		String verifictn =driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
		System.out.println(verifictn);
		boolean status = verifictn.contains("Thank you");
		Assert.assertEquals(status, true);
		
		WebElement ssele= driver.findElement(By.xpath("//div[@data-animation='pop']"));
		TakesScreenshot scsearch1= (TakesScreenshot)ssele;
		
		File src1 = scsearch1.getScreenshotAs(OutputType.FILE);
		File dest1= new File("./Screenshots/AlertValid.png");
		FileHandler.copy(src1, dest1);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.quit();
		
		
		
	}

}
