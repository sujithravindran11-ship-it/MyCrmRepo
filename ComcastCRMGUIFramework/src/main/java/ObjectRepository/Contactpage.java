package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	
	// rule 1 create separate class for separate
	
			//rule2 identify object using @finddby annotation
			WebDriver driver;
		
			public Contactpage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath = "//img[@title='Create Contact...']")
			 private WebElement concreatebtn;
			
			public WebElement getConcreatebtn() {
				return concreatebtn;
			}


}
