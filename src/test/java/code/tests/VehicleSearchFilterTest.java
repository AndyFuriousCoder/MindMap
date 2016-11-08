package code.tests;

import code.elements.FeatureFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class VehicleSearchFilterTest extends TestBase
{


    @BeforeTest
    public void setUp()
    {
        setUpWebDriver();
    }

    @Test(dataProviderClass = SearchingData.class, dataProvider = "SearchByFiltersTest")
    public void checkingSearchingByFilters(String cathegory, String filter1, String value1, String filter2, String value2, String filter3, String value3)
    {
        goToStartPage();
        goByDropDownMenuLink(cathegory);
        setUpFilter(filter1, value1);
        setUpFilter(filter2, value2);
        setUpFilter(filter3, value3);
        checkSearchingByFilters();
    }

    @AfterTest
    public void tearDown()
    {
        closeDriver();
        quitDriver();
    }

}
