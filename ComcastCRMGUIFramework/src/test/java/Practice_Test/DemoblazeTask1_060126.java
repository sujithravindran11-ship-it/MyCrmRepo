package Practice_Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class DemoblazeTask1_060126 {

	@Test
	public void monitors() throws Exception {

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebdriverUtility wlib = new WebdriverUtility();

		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("taskurl");

		WebDriver driver = wlib.driverSelect(browser);
		driver.get(url);
		wlib.waitForPageLoad(driver);

		driver.findElement(By.linkText("Monitors")).click();

		WebElement nextBtn = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));

		Actions actions = new Actions(driver);
//		wlib.waitForElementPresent(driver, nextBtn);
		Thread.sleep(3000);
		actions.moveToElement(nextBtn).click().perform();

		// //div[@class='card-block']/h4|//div[@class='card-block']/h5==path
		// /div[@class='card-block']/h5

		Thread.sleep(3000);
		List<WebElement> moname = driver.findElements(By.xpath("//div[@class='card-block']/h4"));
		List<WebElement> moprice = driver.findElements(By.xpath("//div[@class='card-block']/h5"));

		
		
		for (WebElement elements : moname)
		{
			int i = 1;
			
			String value = elements.getText();

			elib.setStringData("Monitortask", i, 0, value);
			i++;
		}

		
		for (WebElement elements : moprice)
		{
			int i = 1;
			String value = elements.getText();

			elib.setStringData("Monitortask", i, 1, value);
			i++;
		}

//		Thread.sleep(3000);
//
//		List<WebElement> moname =
//		        driver.findElements(By.xpath("//div[@class='card-block']/h4"));
//		List<WebElement> moprice =
//		        driver.findElements(By.xpath("//div[@class='card-block']/h5"));
//
//		FileInputStream fileInputStream=new FileInputStream("D:\\imp.data\\Desktop\\java_prac\\ComcastCRMGUIFramework\\testData\\OrgContactTestscriptdata.xlsx");
//		Workbook wb=WorkbookFactory.create(fileInputStream);
//		Sheet sh=wb.getSheet("Monitortask");
//
//		
//		for (int i = 0; i < moname.size(); i++) {
//			Row row2=sh.getRow(i+1);
//			 if (row2 == null) {
//			        row2 = sh.createRow(i + 1);
//			    }
//			row2.createCell(0).setCellValue(moname.get(i).getText());
////			row2.createCell(1).setCellValue(prices.get(i).getText());
//		}
//		
//
//		for (int i = 0; i < moprice.size(); i++) {
//			Row row2=sh.getRow(i+1);
//			 if (row2 == null) {
//			        row2 = sh.createRow(i + 1);
//			    }
//			row2.createCell(1).setCellValue(moprice.get(i).getText());
//
//		}
//		
//		FileOutputStream fileOutputStream=new FileOutputStream("D:\\imp.data\\Desktop\\java_prac\\ComcastCRMGUIFramework\\testData\\OrgContactTestscriptdata.xlsx");
//		wb.write(fileOutputStream);
//		wb.close();
	}

}
