package Practice_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ShadiAuto {

	@Test
	public void shadi_automate() {
		
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.shadi.com/");

		 driver.findElement(By.linkText("Join Now")).click();
		 
		 driver.findElement(By.id("lbl_rblGender_1")).click(); 
		
	}
}
