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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //    WebDriver wd;
    EventFiringWebDriver wd;
    HelpUser users;
    HelperCar car;
    String browser;
    HelperSearch seach;
    public ApplicationManager(String browser) {
        properties=new Properties();
        this.browser=browser;
    }

    public HelpUser getUsers() {
        return users;
    }

    public HelperCar getCar() {
        return car;
    }

   private Properties properties;

public String getemail(){
    return properties.getProperty("web.email");
}public String getpsw(){
    return properties.getProperty("web.password");
}
    public HelperSearch getSeach() {
        return seach;
    }

    @BeforeSuite
    public void init() throws IOException {
//        properties.load(new FileReader(new File("src/test/resources/prod.properties")));
        String target=System.getProperty("target", "prod");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
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
        seach=new HelperSearch(wd);
//        wd.manage().window().maximize();
//        wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tears() {

           wd.quit();
    }


}
