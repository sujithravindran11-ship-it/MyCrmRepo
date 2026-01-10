package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility{
	// rule 1 create separate class for separate
	
	//rule2 identify object using @finddby annotation
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "user_name")
	 private WebElement usrnameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwrdEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginbutn;
	
	//rule 3 initialize using pagefactory.initelements()


	
	//rule 4 create getter methods for private elements
	public WebElement getUsrnameEdt() {
		return usrnameEdt;
	}

	public WebElement getPasswrdEdt() {
		return passwrdEdt;
	}

	public WebElement getLoginbutn() {
		return loginbutn;
	}
	
	
	//rule 5 provide action
	
	public void loginApp(String username, String password) {
		waitForPageLoad(driver);
		usrnameEdt.sendKeys(username);
		passwrdEdt.sendKeys(password);
		loginbutn.click();
		
	}
}
