package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void type(By locator, String fill) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(fill);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {

        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;

    }


}



