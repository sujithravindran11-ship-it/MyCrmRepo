package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public WebDriver driverSelect(String browser) throws Exception {
		WebDriver driver;

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;

		} else if (browser.equals("edge")) {

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			return driver;
		} else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}

	}

	public void waitForPageLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {

		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(20));
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winndowID = it.next();
			driver.switchTo().window(winndowID);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialUrl)) {
				break;
			}

		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winndowID = it.next();
			driver.switchTo().window(winndowID);

			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}

		}
	}

	public void switchToFrame(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {

		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}

	public void alertToAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void alertToDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {

		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
}