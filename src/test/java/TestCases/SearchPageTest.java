package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FlightSearch;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({Listener.AllureListener.class})

public class SearchPageTest extends BaseClass{
	
	FlightSearch flightsearch;
	
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		flightsearch = new FlightSearch();
		
	}
	@Test(priority=1, description="TitleTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Title Test")

	public void SearchPageTitleTest() {
		String title=flightsearch.ValidateSearchPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	}
	@Test(priority=2, description="LogoTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Logo Test")

	public void FlightSearchLogTest() {
		boolean flag=flightsearch.ValidateSpiceJetImge();
		Assert.assertTrue(flag);
	}
	@Test(priority=3, description="OnewaySearch Test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify OnewaySearch Test")
	public void OnewaySearchTest() throws InterruptedException {
	flightsearch.OneWaySearch("Hyderabad (HYD)", "Goa (GOI)");
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}
	
}
