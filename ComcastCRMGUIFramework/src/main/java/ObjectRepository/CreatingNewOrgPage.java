package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrgPage {
	WebDriver driver;
	public CreatingNewOrgPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "ship_street")
	private WebElement orgshipingEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryEdt;
	
	@FindBy(id="phone")
	private WebElement orgPhno;
	

	
	public WebElement getOrgPhno() {
		return orgPhno;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getOrgshipingEdt() {
		return orgshipingEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	


	public void createOrg(String orgname,String shipping) {
		orgNameEdt.sendKeys(orgname);
		orgshipingEdt.sendKeys(shipping);
		saveBtn.click();
		
	}
	
	public void createOrg(String orgname,String shipping, String industry) {
		orgNameEdt.sendKeys(orgname);
		orgshipingEdt.sendKeys(shipping);
		Select sel = new Select(industryEdt);
		sel.selectByVisibleText(industry);
		saveBtn.click();
		
	}
	
//	public void createOrg(String orgname,String shipping, long phno) {
//		orgNameEdt.sendKeys(orgname);
//		orgshipingEdt.sendKeys(shipping);
//		orgPhno.sendKeys(phno);
//		saveBtn.click();
//	}
}