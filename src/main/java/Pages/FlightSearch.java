package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class FlightSearch extends BaseClass {

	// Page Factory or Object Repository:

	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_0")
	WebElement OneWay;

	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_1")
	WebElement RoundTrip;

	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_2")
	WebElement MultiCity;

	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement From;

	@FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT")
	WebElement To;

	@FindBy(id = "ctl00_mainContent_view_date1")
	WebElement DatePicker;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[6]/div[2]")
	WebElement Passengers;

	@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[3]/div[1]/div[6]/div[3]/div[1]/div[2]/span[3]")
	WebElement Adult;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	WebElement Currency;

	@FindBy(id = "ctl00_mainContent_btn_FindFlights")
	WebElement SearchButton;

	@FindBy(xpath = "//a[@class='spicejet_logo']")
	WebElement SpiceJetLogo;

	// Initializing the page Objects by using constructor
	public FlightSearch() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidateSearchPageTitle() {
		return driver.getTitle();
	}

	public boolean ValidateSpiceJetImge() {
		return SpiceJetLogo.isDisplayed();
	}

	public static String Month = "April";
	public static String day = "16";

	public void OneWaySearch(String DepCity, String ArvCity) throws InterruptedException {
		OneWay.click();
		From.click();
		From.sendKeys(DepCity);
		Thread.sleep(3000);
		To.clear();
		Thread.sleep(3000);
		To.sendKeys(ArvCity);
		DatePicker.click();
		while (true) {// Take xpath of month and store in variable, so it will check to current month
			// to given month
			// when condition given month is equals to text, the loop will be break
			String text = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]"))
					.getText();
			// System.out.println(text);
			if (text.equals(Month))

			{
				break;
			} else {// if above condition not satisfied it moves to else condition and click on next
					// month arrow button
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
			}

		}
		// below is customize xpath, taken xpath from one date and removed tr and td
		// array numbers and then added text()=parameter of date
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td/a[1][text()=" + day + "]"))
				.click();
		Thread.sleep(2000);
		Passengers.click();
		Thread.sleep(2000);
		Adult.click();
		Thread.sleep(2000);
		SearchButton.click();
	}
	
		
}
