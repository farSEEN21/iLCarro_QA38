package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;


public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void type(By locator, String fill) {
        WebElement element = wd.findElement(locator);
//        element.click();
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

    public void takeScreenshot(String link)
    {
        File tmp=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {e.printStackTrace();}

    }
}



