import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)

public class LoginTests extends TestBase {


    @BeforeMethod
    public void precon() {
        if(app.getUsers().isLogged()) app.getUsers().logout();
    }

@AfterTest
public void postTest(){
    if(app.getUsers().isLogged()) app.getUsers().logout();
}
    @Test
    public void LoginPosit() {
        app.getUsers().openLoginForm();
        app.getUsers().fillLoginForm("x2fd34tjCp!", "xcvv@df.ru");
        app.getUsers().pause(2000);
        app.getUsers().submitLogin();
        Assert.assertTrue(app.getUsers().isLoggedSuccess());
//       app.getUsers().logout();

    }

    @Test
    public void LoginPositUser() {
//    User user=new User("xcvv@df.ru","x2fd34tjCp");
        User user = new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!");
        app.getUsers().openLoginForm();
        app.getUsers().fillLoginForm(user.getPsw(), user.getEmail());

        app.getUsers().submitLogin();
        Assert.assertTrue(app.getUsers().isLoggedSuccess());
       //  app.getUsers().logout();
//        app.getUsers().pause(2000);
    }

    @Test
    public void LoginPositUserData() {

        User user = new User().withPsw("x2fd34tjCp!").withEmail("xcvv@df.ru");
        app.getUsers().openLoginForm();
        app.getUsers().fillLoginForm(user);
        app.getUsers().pause(2000);
        app.getUsers().submitLogin();
        Assert.assertTrue(app.getUsers().isLoggedSuccess());
        //app.getUsers().logout();
        app.getUsers().pause(2000);
    }






    @AfterMethod
    public void postcond() {

        app.getUsers().clickOkButton();
        app.getUsers().pause(2000);

    }
}
