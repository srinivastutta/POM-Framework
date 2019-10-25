package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HotelSearch;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({Listener.AllureListener.class})

public class HotelSearchTest extends BaseClass{
	
	HotelSearch hotelsearch;
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		hotelsearch = new HotelSearch();
		
	}
	@Test(priority=1, description="TitleTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Title Test")

	public void HotelSearchPageTitleTest() {
		String title=hotelsearch.ValidateHotelPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}
	
	@Test(priority=2, description="HotelSearchTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Hotel Search Test")
	public void HotelSearchcheck() {
	hotelsearch.HotelSearching();
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}
}



