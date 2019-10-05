package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;

public class HotelSearch extends BaseClass {
	
	@FindBy(xpath="//span[contains(text(),'Hotels')]")
	WebElement Hotels;
	
	@FindBy(name="ctl00$mainContent$txtOriginStation1_MST")
	WebElement DestCity;
	
	@FindBy(xpath="//select[@id='ddl_Adult_MST']")
	WebElement Adults;
	
	@FindBy(xpath="//select[@id='ddl_Child_MST']")
	WebElement Childs;
	
	@FindBy(xpath="//select[@id='ddl_Infant_MST']")
	WebElement Infants;
	
	@FindBy(xpath="//div[@class='mySpiceTrip']//div[4]//button[1]")
	WebElement CheckInDate;
	
	@FindBy(xpath=" //div[@id='ReturnDate_MST']//button[@class='ui-datepicker-trigger']")
	WebElement CheckOutDate;
	
	@FindBy(xpath=" //input[@id='ctl00_mainContent_ButtonSubmit_MST']")
	WebElement SearchButton;
	
	// Initializing the page Objects by using constructor
		public HotelSearch() {
			PageFactory.initElements(driver, this);
		}

		// Actions
		public String ValidateHotelPageTitle() {
			return driver.getTitle();
		}

	public static String CIMonth = "April";
	public static String CIday = "16";

	public static String COMonth = "April";
	public static String COday = "18";

	public void HotelSearching() {
		Hotels.click();
		CheckInDate.click();
		//Select CheckIn Date
		while (true) {// Take xpath of month and store in variable, so it will check to current month
			// to given month
			// when condition given month is equals to text, the loop will be break
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/span[1]")).getText();
			// System.out.println(text);
			if (text.equals(CIMonth))

			{
				break;
			} else {// if above condition not satisfied it moves to else condition and click on next
					// month arrow button	
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/a[1]/span[1]")).click();
			}

		}
		// below is customize xpath, taken xpath from one date and removed tr and td
		// array numbers and then added text()=parameter of date
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td/a[1][text()=" + CIday + "]")).click();

		
		CheckOutDate.click();
	//Select CheckOut Date
	while (true) {// Take xpath of month and store in variable, so it will check to current month
		// to given month
		// when condition given month is equals to text, the loop will be break
		String text = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/span[1]")).getText();
		// System.out.println(text);
		if (text.equals(COMonth))

		{
			break;
		} else {// if above condition not satisfied it moves to else condition and click on next
				// month arrow button	
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/a[1]/span[1]")).click();
		}

	}
	// below is customize xpath, taken xpath from one date and removed tr and td
	// array numbers and then added text()=parameter of date
	driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td/a[1][text()=" + COday + "]")).click();

	Select Adult= new Select(driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[7]/div[1]/div[1]/div[6]/p[1]/select[1]")));
	Adult.selectByValue("3");
	SearchButton.click();
	
	
}

}