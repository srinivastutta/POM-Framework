package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FlightSearch;

public class SearchPageTest extends BaseClass{
	
	FlightSearch flightsearch;
	
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		flightsearch = new FlightSearch();
		
	}
	@Test(priority=1)
	public void SearchPageTitleTest() {
		String title=flightsearch.ValidateSearchPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}
	@Test(priority=2)
	public void FlightSearchLogTest() {
		boolean flag=flightsearch.ValidateSpiceJetImge();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void OnewaySearchTest() throws InterruptedException {
		flightsearch.OneWaySearch("Hyderabad (HYD)", "Goa (GOI)");
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}
	
}
