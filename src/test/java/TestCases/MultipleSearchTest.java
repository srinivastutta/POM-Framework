package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FlightSearch;
import Util.UtilClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jxl.read.biff.BiffException;


@Listeners({Listener.AllureListener.class})

public class MultipleSearchTest extends BaseClass{
	
	FlightSearch flightsearch;
	
	@BeforeMethod
	public void Setup() throws IOException {
		InitProp();
		initialization();
		flightsearch = new FlightSearch();
		
	}
	@DataProvider
	public Iterator<Object[]> GetTestData() throws BiffException, IOException {
		ArrayList<Object[]>testdata=UtilClass.getDataFromExcel();
		return testdata.iterator();
		
	}
			
	@Test(dataProvider="GetTestData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Multiple Search Test")

	public void MultipleSearch (String DepCity, String ArvCity) throws InterruptedException, BiffException{
	flightsearch.OneWaySearch(DepCity, ArvCity);		

	}
	@AfterMethod
	public void TearDown() {
	driver.quit();	
	
	}
}
