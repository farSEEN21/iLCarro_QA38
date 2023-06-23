import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistratoinTest extends TestBase{

    @BeforeMethod
    public void precon(){
        if (app.getUsers().isLogged())app.getUsers().logout();
    }

    @Test
    public void positiveRegist(){

        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user=new User().withName("Jaffar").withLastname("safw").withEmail("fon"+i+"@gmail.ru").withPsw("$Asdf1234");

app.getUsers().openRegistationForm();
app.getUsers().fillRegistrationForm(user);
app.getUsers().submitLogin();
  Assert.assertTrue(app.getUsers().isLoggedSuccess());



    }
@AfterMethod
    public void postcond(){
        app.getUsers().clickOkButton();
}


}
