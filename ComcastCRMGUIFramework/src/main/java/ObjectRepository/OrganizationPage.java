package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage	(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	 private WebElement organiztionLnk;
	
	@FindBy(name ="search_text")
	 private WebElement searchBox;
	
	@FindBy(id ="bas_searchfield")
	 private WebElement namedropdown;
	
	@FindBy(name ="submit")
	 private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath= "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
//input[@onclick="return massDelete('Accounts')"]//input[@onclick="return massDelete('Accounts')"]
	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getNamedropdown() {
		return namedropdown;
	}

	public WebElement getOrganiztionLnk() {
		return organiztionLnk;
	}
	
	
}
