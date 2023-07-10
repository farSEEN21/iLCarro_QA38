package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //    WebDriver wd;
    EventFiringWebDriver wd;
    HelpUser users;
    HelperCar car;
    String browser;
    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public HelpUser getUsers() {
        return users;
    }

    public HelperCar getCar() {
        return car;
    }



    @BeforeSuite
    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests start on Chrome");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests start on Firefox");
        }

//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WDListener());
        users = new HelpUser(wd);
        car = new HelperCar(wd);
//        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tears() {

        //   wd.quit();
    }


}
