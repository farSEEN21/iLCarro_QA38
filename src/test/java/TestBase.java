import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase  {
    Logger logger= LoggerFactory.getLogger(TestBase.class);
    static ApplicationManager app=new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }


    @AfterSuite
    public void stop(){
        app.tears();
    }

}
