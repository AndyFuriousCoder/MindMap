package code.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VehicleSearchFilterTest extends TestBase
{

    @BeforeTest
    public void setUp()
    {
        setUpWebDriver();
    }

    @Test(dataProviderClass = SearchingData.class, dataProvider = "SearchByFiltersTest")
    public void checkingSearchingByFilters(String cathegory, String filter1, String value1, String filter2, String value2)
    {
        goToStartPage();
        goByDropDownMenuLink(cathegory);
        setUpFilter(filter1, value1);
        setUpFilter(filter2, value2);
        checkSearchingByFilters();
    }

    @AfterTest
    public void tearDown()
    {
        closeDriver();
        quitDriver();
    }

}
