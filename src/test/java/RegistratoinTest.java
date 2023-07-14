import manager.ProviderData;
import manager.TestNGListener;
import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)

public class RegistratoinTest extends TestBase {

    @BeforeMethod
    public void precon() {
        if (app.getUsers().isLogged()) app.getUsers().logout();
    }

    @Test
    public void positiveRegist() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withName("Jaffar").withLastname("safw").withEmail("fon" + i + "@gmail.ru").withPsw("$Asdf1234");

        app.getUsers().openRegistationForm();
        logger.info("openRegistationForm");
        app.getUsers().fillRegistrationForm(user);
        logger.info("fillRegistrationForm");
        app.getUsers().submitLogin();
        logger.info("positiveRegist Starts with credentials: login"+user.getEmail()+" Password:  "+ user.getPsw());
        Assert.assertTrue(app.getUsers().isLoggedSuccess());
    }
   @Test(dataProvider = "UserDTOCSV",dataProviderClass = ProviderData.class  )
    public void positiveRegistDTO(User user) {

//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        User user = new User().withName("Jaffar").withLastname("safw").withEmail("fon" + i + "@gmail.ru").withPsw("$Asdf1234");

        app.getUsers().openRegistationForm();
        logger.info("openRegistationForm");
        app.getUsers().fillRegistrationForm(user);
        logger.info("fillRegistrationForm");
        app.getUsers().submitLogin();
        logger.info("positiveRegist Starts with credentials: login"+user.getEmail()+" Password:  "+ user.getPsw());
        Assert.assertTrue(app.getUsers().isLoggedSuccess());
    }

    @Test
    public void NegRegistWrongPSW() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        UserLombok userLo = UserLombok.builder().name("Johnny").lastname("shmitt").email("do" + i + "@gmail.co").psw("Asdf1234").build();
        app.getUsers().openRegistationForm();
        app.getUsers().fillRegistrationForm(userLo);
        app.getUsers().submitLogin();
        app.getUsers().pause(3000);
//            Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));
//        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));


    }

//    @Test
//    public void RegistNegativPassword() {
//
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        UserLombok userLo = UserLombok.builder().name("Johnny").lastname("shmitt").email("do" + i + "@gmail.co").psw("$asdf1234").build();
//        app.getUsers().openRegistationForm();
//        app.getUsers().fillRegistrationForm(userLo);
//        app.getUsers().submitLogin();
//        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));
////        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));
//
//
//    }

    @AfterMethod
    public void postcond() {
        app.getUsers().pause(3000);
        app.getUsers().clickOkButton();
    }


}
