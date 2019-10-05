package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HotelSearch;

public class HotelSearchTest extends BaseClass{
	
	HotelSearch hotelsearch;
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		hotelsearch = new HotelSearch();
		
	}
	@Test(priority=1)
	public void HotelSearchPageTitleTest() {
		String title=hotelsearch.ValidateHotelPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}
	
	@Test(priority=2)
	public void HotelSearchcheck() {
		hotelsearch.HotelSearching();
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}
}



