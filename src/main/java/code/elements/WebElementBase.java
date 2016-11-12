package code.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementBase {

    protected By locator;
    protected String name;
    protected WebElement element;
    protected WebDriver driver;

    public WebElement getElement()
    {
        if(element == null)
        {
            element = driver.findElement(locator);
        }
        return element;
    }

    public String getElementText()
    {
        return getElement().getText();
    }


}
