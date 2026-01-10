package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTroubleticketspage {
	
	// rule 1 create separate class for separate
	
			//rule2 identify object using @finddby annotation
			WebDriver driver;
		
			public CreateTroubleticketspage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(name = "ticket_title")
			 private WebElement titleEdt;
			
			@FindBy(name = "ticketpriorities")
			 private WebElement priority;

			@FindBy(name = "ticketseverities")
			 private WebElement severity;
			
			@FindBy(name = "ticketstatus")
			 private WebElement status;
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			 private WebElement Savebtn;
			
			
			public WebElement getPriority() {
				return priority;
			}

			public WebElement getSeverity() {
				return severity;
			}

			public WebElement getStatus() {
				return status;
			}

			public WebElement getSavebtn() {
				return Savebtn;
			}

			public WebElement gettitleEdt() {
				return titleEdt;
			}


}
