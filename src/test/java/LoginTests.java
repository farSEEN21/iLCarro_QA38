import manager.HelpUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

@BeforeTest
public void IsLog()
{if(app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]"))){
    app.getUsers().logout();}
}
    @Test
    public void LoginPosit() {


        app.getUsers().logIn();
        app.getUsers().fillformYalla("x2fd34tjCp!", "xcvv@df.ru");
        app.getUsers().pause(2000);
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
        app.getUsers().logout();
        app.getUsers().pause(2000);
    }
}
