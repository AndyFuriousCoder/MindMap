package code.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownMenuListElements extends WebElementBase
{

    public DropDownMenuListElements(WebDriver driver, String name)
    {
        this.name = name;
        this.driver = driver;
        this.locator = By.linkText(name);
    }

}
