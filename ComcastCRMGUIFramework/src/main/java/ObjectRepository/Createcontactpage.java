package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcontactpage {

	// rule 1 create separate class for separate

	// rule2 identify object using @finddby annotation
	WebDriver driver;

	public Createcontactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement contactLastNedt;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement contactorgSelect;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement contactSavebtn;

	@FindBy(name = "support_start_date")
	private WebElement contactSupprtStrtDateEdt;

	public WebElement getContactSupprtStrtDateEdt() {
		return contactSupprtStrtDateEdt;
	}

	public WebElement getContactSupprtEndDateEdt() {
		return contactSupprtEndDateEdt;
	}

	@FindBy(name = "support_end_date")
	private WebElement contactSupprtEndDateEdt;

	public WebElement getContactLastNedt() {
		return contactLastNedt;
	}

	public WebElement getContactorgSelect() {
		return contactorgSelect;
	}

	public WebElement getContactSavebtn() {
		return contactSavebtn;
	}

}
