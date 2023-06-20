import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {



    @Test
    public void LoginPosit() {
        app.getUsers().logIn();
        app.getUsers().fillformYalla("x2fd34tjCp!", "xcvv@df.ru");
        app.getUsers().pause(2000);
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
        app.getUsers().logout();
        app.getUsers().pause(2000);
    }

    @Test
    public void LoginPositUser() {
//    User user=new User("xcvv@df.ru","x2fd34tjCp");
        User user = new User().withEmail("x2fd34tjCp").withPsw("xcvv@df.ru");
        app.getUsers().logIn();
        app.getUsers().fillformYalla(user.getPsw(), user.getEmail());
        app.getUsers().pause(2000);
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
        app.getUsers().logout();
        app.getUsers().pause(2000);
    } @Test
    public void LoginPositUserData() {

        User user = new User().withEmail("x2fd34tjCp").withPsw("xcvv@df.ru");
        app.getUsers().logIn();
        app.getUsers().fillformYalla(user);
        app.getUsers().pause(2000);
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
        app.getUsers().logout();
        app.getUsers().pause(2000);
    }


}
