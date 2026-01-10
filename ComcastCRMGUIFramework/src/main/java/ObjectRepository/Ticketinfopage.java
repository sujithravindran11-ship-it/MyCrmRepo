package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ticketinfopage {
	
	// rule 1 create separate class for separate
	
			//rule2 identify object using @finddby annotation
			WebDriver driver;
		
			public Ticketinfopage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath = "//div[@id='tblTicketInformation']/table/tbody/tr[7]/td[2]")
			 private WebElement tckno;
			
			public WebElement gettckno() {
				return tckno;
			}


}
