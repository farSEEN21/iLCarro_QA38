import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEachTests extends TestBase {


    @Test(groups = {"seachcheck"})
    public void SheachByCityAndWriteDate() {

        app.getSeach().openFormCar();
        app.getSeach().typeCitySeach("Tel Aviv");
        app.getSeach().typeDate("7/18/2023 - 7/25/2023");
        app.getUsers().submitLogin();
        app.getUsers().pause(3000);
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='search-results-card']")));
    }

    @Test
    public void SheachByCityAndDate() {

        app.getSeach().openFormCar();
        app.getSeach().typeCitySeach("Tel Aviv");
        app.getSeach().findDate();
        app.getUsers().pause(3000);
        app.getUsers().submitLogin();
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='search-results-card']")));
    }
    @Test
    public void SheachByCityAndAnyDate() {

        app.getSeach().openFormCar();
        app.getSeach().typeCitySeach("Tel Aviv");
        app.getSeach().AnyMonthDate();
        app.getUsers().pause(3000);
        app.getUsers().submitLogin();
        Assert.assertTrue(app.getUsers().isElementPresent(By.xpath("//div[@class='search-results-card']")));
    }


}
