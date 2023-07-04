package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WDListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);
    public WDListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element by --->" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("find element with --->" + by + "is found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong" + throwable.getMessage() + throwable.fillInStackTrace());
        int i= (int)(System.currentTimeMillis()/1000)%3600;
        String link ="src/test/screenshots/screen-"+i+".png";
        HelperBase helperBase=new HelperBase(driver);
        helperBase.takeScreenshot(link);
        logger.info("THis is a link to a Screenshot with error----->"+link);

    }

}

