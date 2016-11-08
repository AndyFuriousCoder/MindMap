package code.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeatureFilter extends WebElementBase {

    public FeatureFilter(WebDriver driver, String name)
    {
        this.locator = By.xpath("//button[contains(.,'" + name + "')]");
        this.name = name;
        this.driver = driver;

    }

}
