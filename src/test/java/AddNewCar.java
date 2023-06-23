import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{




    @BeforeMethod
    public void precon(){
        if (app.getUsers().isLogged()==false) app.getUsers().login(
                new User().withEmail("xcvv@df.ru").withPsw("x2fd34tjCp!"));
    }


    @Test
    public void addNewCarPos(){
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        Car car= Car.builder()
                .locat("Tel Aviv")
                .make("Kai")
                .Model("DP")
                .year("2010")
                .fuel("Diesel")
                .seat("3")
                .carClass("B1")
                .serialNumberPlate("100-200-"+i)
                .price("321")
                .about("s")
                .build();
app.getCar().openFormCar();
app.getCar().fillCarForm(car);
app.getUsers().submitLogin();
    }


}
