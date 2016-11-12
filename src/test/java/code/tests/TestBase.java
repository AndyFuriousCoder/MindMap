package code.tests;

import code.elements.DropDownMenuCars;
import code.elements.DropDownMenuListElements;
import code.elements.FeatureFilter;
import code.elements.GeoLocationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

@Listeners({CustomTestListener.class})
public class TestBase
{
    private static WebDriver driver;
    private String startPageURL = "https://auto.ru/";// start page for tests "Авто.ру"

    //set up web driver for functional test
    public WebDriver setUpWebDriver()
    {
        String browser = java.lang.System.getProperties().getProperty("webbrowser");
        if(browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        if(browser.equalsIgnoreCase("opera")) driver = new OperaDriver();
        if(browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
        if(browser.equalsIgnoreCase("ie")) driver = new InternetExplorerDriver();
        if(browser.equalsIgnoreCase("safari")) driver = new SafariDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    //set up web driver for geolocation test
    public WebDriver setUpGeolocationTestDriver()
    {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        profile.setPreference("geo.wifi.uri", "file:///C:/Users/MACHINE/IdeaProjects/VehicleSearchFilterTest/src/test/resourses/geoLocation.json");
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    //geolocation checking for "Moscow"
    public void checkGeolocation(String geoLocation)
    {
        //driver.findElement(By.xpath("//a[contains(text(),'Нет')]")).click();
        new GeoLocationContext(driver, "Нет").getElement().click();
        assertEquals(new GeoLocationContext(driver, "Москва").getElementText(), geoLocation);
    }

    public static WebDriver getWebDriver()
    {
        return driver;
    }

    //go to auto.ru
    public void goToStartPage()
    {
        goToPage(startPageURL);
    }

    // go to another page
    public void goToPage(String url)
    {
        driver.navigate().to(url);
    }

    //use dropdown menu "Легковые"
    public void goByDropDownMenuLink(String value)
    {
        new DropDownMenuCars(driver, "Легковые").getElement().click();
        new DropDownMenuListElements(driver, value).getElement().click();
    }

    //use filters on site
    public void setUpFilter(String filter, String value)
    {
        FeatureFilter webFilter =  new FeatureFilter(driver, filter);
        webFilter.getElement().click();
        webFilter.getElement().sendKeys(value);
    }

    //check searching result
    public void checkSearchingByFilters()
    {
        assertEquals(driver.findElement(By.linkText("Сбросить")).getText(), "Сбросить");
    }

    public void closeDriver()
    {
        driver.close();
    }

    public void quitDriver()
    {
        driver.quit();
    }
}
