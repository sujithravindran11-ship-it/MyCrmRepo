package Practice_Test;



import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class DemoblazeTask3_60126 {
	
	@Test(dataProvider = "getData")
	public void monitors(String name,String country, String city, String credcard, String month, String year) throws Exception {
		
		FileUtility flib= new FileUtility();
		ExcelUtility elib= new ExcelUtility();
		WebdriverUtility wlib= new WebdriverUtility();
		
		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("taskurl");
		
		
		
		WebDriver driver= wlib.driverSelect(browser);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		
		driver.findElement(By.linkText("Laptops")).click();
		
		driver.findElement(By.xpath("(//a[@class='hrefch'])[position()=3]")).click();
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(2000);
		wlib.alertToAccept(driver);
		driver.findElement(By.linkText("Cart")).click();
		
		
		
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement wname=driver.findElement(By.id("name"));
		wlib.waitForElementPresent(driver, wname);
		wname.sendKeys(name);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("city")).sendKeys(city);
		WebElement wcred= driver.findElement(By.id("card"));
		wlib.waitForElementPresent(driver, wcred);
		wcred.sendKeys(credcard);
		driver.findElement(By.id("month")).sendKeys(month);
		driver.findElement(By.id("year")).sendKeys(year);


		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		
		String verifictn =driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();
		System.out.println(verifictn);
		boolean status = verifictn.contains("Thank you");
		Assert.assertEquals(status, true);
		
	
		driver.quit();
		
	}
	
	@DataProvider
	
	public Object[][] getData() throws Exception {	
		
	ExcelUtility eLib = new ExcelUtility();

		int rowcount = eLib.getRowCount("Placeorderdetails");
		System.out.println(rowcount);

		Object[][] objArr = new Object[rowcount][6];

		for (int i = 0; i < rowcount; i++) {
			objArr[i][0] = eLib.getStringData("Placeorderdetails", i+1, 0);
			objArr[i][1] = eLib.getStringData("Placeorderdetails", i+1, 1);
			objArr[i][2] = eLib.getStringData("Placeorderdetails", i+1, 2);
			objArr[i][3] = eLib.getStringData("Placeorderdetails", i+1, 3);
			objArr[i][4] = eLib.getStringData("Placeorderdetails", i+1, 4);
			objArr[i][5] = eLib.getStringData("Placeorderdetails", i+1, 5);

		}
	return objArr;
	}

}


