package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadsPage {
	
	// rule 1 create separate class for separate
	
			//rule2 identify object using @finddby annotation
			WebDriver driver;
		
			public CreateLeadsPage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(name = "lastname")
			 private WebElement lastNameEdt;
			
			@FindBy(name = "company")
			 private WebElement companyEdt;
			
			@FindBy(xpath = "//input[@type='radio' and @value='U']")
			private WebElement userradio;
			
			@FindBy(xpath = "//input[@type='radio' and @value='T']")
			private WebElement grpradio;
			
			@FindBy(name = "assigned_user_id")
			private WebElement userdrpdown;
			
			@FindBy(name = "assigned_group_id")
			private WebElement grpdrpdown;
			
			public WebElement getGrpradio() {
				return grpradio;
			}

			public WebElement getGrpdrpdown() {
				return grpdrpdown;
			}

			public WebElement getUserradio() {
				return userradio;
			}

			public WebElement getUserdrpdown() {
				return userdrpdown;
			}

			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			
			public WebElement getLastNameEdt() {
				return lastNameEdt;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}

			public WebElement getcompanyEdt() {
				return companyEdt;
			}


}
