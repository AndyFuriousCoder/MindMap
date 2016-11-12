package code.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeolocationTest extends TestBase {

    @BeforeTest
    public void setUp()
    {
        setUpGeolocationTestDriver();
    }

    @Test
    public void checkingGeolocationTest()
    {
        goToStartPage();
        checkGeolocation("Москва + 200 км");
    }

    @AfterTest
    public void tearDown()
    {
        closeDriver();
        quitDriver();
    }

}
