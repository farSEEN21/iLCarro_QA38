import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase  {

 static    ApplicationManager app=new ApplicationManager();
 @BeforeMethod
public void precondition(){

         if (app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]"))) {
             app.getUsers().logout();
         }

 }
    @BeforeSuite
    public void setUp() {
        app.init();
    }


    @AfterSuite
    public void stop(){
        app.tears();
    }

    @AfterMethod
    public void postcondition(){
        app.getUsers().logout();
    }
}
