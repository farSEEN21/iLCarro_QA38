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
HelperCar car;

    public HelpUser getUsers() {
        return users;
    }

    public HelperCar getCar() {
        return car;
    }


    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        users=new HelpUser(wd);
        car=new HelperCar(wd);
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tears() {

     //   wd.quit();
    }



}
