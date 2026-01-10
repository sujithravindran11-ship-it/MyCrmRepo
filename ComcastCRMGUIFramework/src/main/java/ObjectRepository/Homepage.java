package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	// rule 1 create separate class for separate
	
		//rule2 identify object using @finddby annotation
		WebDriver driver;
		public Homepage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(linkText = "Organizations")
		 private WebElement organiztionLnk;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactlnk;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutBtn;
		
		@FindBy(linkText = "Leads")
		private WebElement leadlnk;
		
		@FindBy(linkText = "Trouble Tickets")
		private WebElement ticketlnk;
		
		public WebElement getTicketlnk() {
			return ticketlnk;
		}

		public WebElement getLeadlnk() {
			return leadlnk;
		}

		public WebElement getOrganiztionLnk() {
			return organiztionLnk;
		}

		public WebElement getAdminImg() {
			return adminImg;
		}

		public WebElement getContactlnk() {
			return contactlnk;
		}

		public WebElement getSignoutBtn() {
			return signoutBtn;
		}
		
		public void logOutApp() {
			
			Actions act = new Actions(driver);
			act.moveToElement(adminImg).perform();
			signoutBtn.click();
			
			
		}

}
