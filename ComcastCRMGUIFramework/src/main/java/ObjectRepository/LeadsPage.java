package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	// rule 1 create separate class for separate
	
			//rule2 identify object using @finddby annotation
			WebDriver driver;
		
			public LeadsPage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath = "//img[@alt='Create Lead...']")
			 private WebElement leadcreatebtn;
			
			public WebElement getleadcreatebtn() {
				return leadcreatebtn;
			}


}
