package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FlightStatus;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({Listener.AllureListener.class})

public class FlightStatusTest extends BaseClass {
	
	FlightStatus flightStatus;
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		flightStatus= new FlightStatus();
		
	}
	
	@Test(priority=1, description="TitleTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Title Test")
	
	public void FlightstatusPageTitleTest() {
		String title=flightStatus.ValidateFlightStatusPageTitle();
		if (title.contains("Book Low Cost Air Tickets")) {
			Assert.assertTrue(true);
		}
	}
	
	@Test(priority=2, description="FlightStatusImageTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify FlightStatus Page LogoTest")
	
	public void FlightStatusLogoTest() {
	boolean Logo=flightStatus.FlightStatsImage();
	Assert.assertEquals(Logo, true);
	}
	
	@Test(priority=3, description="FlightStatus Test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Flight Status Search Test")
	public void FlightStatusSearchTest() {
	flightStatus.FlightstatsSearch();
	}
	
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	}

}
