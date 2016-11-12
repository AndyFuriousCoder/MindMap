package code.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeoLocationContext extends WebElementBase
{
    public GeoLocationContext(WebDriver driver, String name)
    {
        this.name = name;
        this.driver = driver;
        this.locator = By.xpath("//a[contains(text(),'"+ name + "')]");
    }

}
