import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistratoinTest extends TestBase{

//    @BeforeMethod
//    public void precon(){
//        if (app.getUsers().isElementPresent(By.xpath("//a[.=' Log in ']"))) app.getUsers().Login(new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!"));
//    }

    @Test
    public void positiveRegist(){

        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user=new User().withName("Jaffar").withLastname("safw").withEmail("fon"+i+"@gmail.ru").withPsw("$Asdf1234");

app.getUsers().openregform();
app.getUsers().regFillForm(user);
       app.getUsers().click(By.xpath("//button[.='Ok']"));
   //     Assert.assertTrue(app.getUsers().);



    }



}
