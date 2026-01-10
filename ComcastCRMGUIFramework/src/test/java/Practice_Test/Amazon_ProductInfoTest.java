package Practice_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class Amazon_ProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfo(String brandname, String productname) throws Throwable {
		WebdriverUtility wLib = new WebdriverUtility();

		WebDriver driver = wLib.driverSelect("chrome");

		wLib.waitForPageLoad(driver);
		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

		// capture product name
		// String x=
		// "//span[text()='"+productname+"']/ancestor::div[@data-cy=\"title-recipe\"]/following-sibling::div[@class=\"puisg-row\"]/descendant::span[@class=\"a-price-whole\"]";
		String x = "//span[contains(text(),'" + productname+ "')]/ancestor::div[@data-component-type='s-search-result']//span[@class='a-price-whole']";
		WebElement wbElement= driver.findElement(By.xpath(x));
		//wLib.waitForElementPresent(driver, wbElement);
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();

	}
	//// span[text()='Apple iPhone 16 Pro Max, US Version, 512GB, Black Titanium -
	//// Unlocked
	//// (Renewed)']/ancestor::div[@data-cy="title-recipe"]/following-sibling::div[@class="puisg-row"]/descendant::span[@class="a-price-whole"]

	@DataProvider
	public Object[][] getData() throws Exception {
		ExcelUtility eLib = new ExcelUtility();

		int rowcount = eLib.getRowCount("phone");
		System.out.println(rowcount);

		Object[][] objArr = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
			objArr[i][0] = eLib.getStringData("phone", i + 1, 0);
			objArr[i][1] = eLib.getStringData("phone", i + 1, 1);
		}
		return objArr;
	}

//	public void getData() throws Exception{
//		ExcelUtility eLib= new ExcelUtility();
//		int rowcount= eLib.getRowCount("phone");
//		System.out.println(rowcount);
//		
//		Object[][] objArr= new Object[rowcount][2];
//		
//		for(int i=0;i<rowcount;i++)
//		{
//			objArr[i][0]=eLib.getStringData("phone", i+1, 0);
//			objArr[i][1]=eLib.getStringData("phone", i+1, 1);
//		}
//		System.out.println(objArr);
//	}

}
