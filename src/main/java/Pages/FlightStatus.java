package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseClass;

public class FlightStatus extends  BaseClass{
	
	
	@FindBy(linkText="Flight Status")
	WebElement FlightStatustab;
	
	
	@FindBy(id="FlifoSearchInputSearchView_originStation")
	WebElement DepCity;
	
	
	@FindBy(id="FlifoSearchInputSearchView_destinationStation")
	WebElement ArrCity;
	
	
	@FindBy(id="FlifoSearchInputSearchView_DropDownListFlightDate")
	WebElement DepartDate;
	
	
	@FindBy(id="FlifoSearchInputSearchView_TextBoxFlightNumber")
	WebElement FlightNo;
	
	
	@FindBy(id="FlifoSearchInputSearchView_ButtonSubmit")
	WebElement SearchButton;
	
	@FindBy(xpath="//a[@class='spicejet_logo']")
	WebElement FlightStatsLogo;
	
	
	//Initializing the page objects by using constructor
	public FlightStatus() {
		PageFactory.initElements(driver,this);
		
	}
	
	//Actions
	public String ValidateFlightStatusPageTitle() {
		FlightStatustab.click();
		return driver.getTitle();
		
	}
	
	public boolean FlightStatsImage() {
		FlightStatustab.click();
		return FlightStatsLogo.isDisplayed();
		
	}
	
	public void FlightstatsSearch() {
		FlightStatustab.click();
		
		DepCity.click();
		
		Select fromCity=new Select(DepCity);
		fromCity.selectByValue("HYD");
		
		ArrCity.click();
		Select ToCity= new Select(ArrCity);
		ToCity.selectByValue("DEL");
		
		DepartDate.click();
		Select DepDate= new Select(DepartDate);
		DepDate.selectByIndex(3);
		SearchButton.click();
		
	}
	
}
