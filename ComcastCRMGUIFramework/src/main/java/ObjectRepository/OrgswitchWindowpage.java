package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgswitchWindowpage {
	// rule 1 create separate class for separate
	
				//rule2 identify object using @finddby annotation
				WebDriver driver;
				public OrgswitchWindowpage(WebDriver driver){
					this.driver=driver;
					PageFactory.initElements(driver,this);
				}
				
				@FindBy(id = "search_txt")
				private WebElement orgwindSearch;
				
				public WebElement getOrgwindSearch() {
					return orgwindSearch;
				}

				public WebElement getOrgwindSearchbtn() {
					return orgwindSearchbtn;
				}

				@FindBy(name = "search")
				private WebElement orgwindSearchbtn;
				
				
}

