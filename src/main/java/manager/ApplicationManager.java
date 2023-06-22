package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {



    WebDriver wd;
    HelpUser users;


    public HelpUser getUsers() {
        return users;
    }

    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        users=new HelpUser(wd);
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }


    @AfterSuite
    public void tears() {

        wd.quit();
    }



}
