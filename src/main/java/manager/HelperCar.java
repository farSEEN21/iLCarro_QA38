package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.text;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openFormCar() {
        pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));
    }


    public void fillCarForm(Car car) {
        if (isCarFormPresent() == false) return;
        typeLocation(car.getLocat());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        SelectFuel(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeat());
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getSerialNumberPlate());
        type(By.id("price"), car.getPrice());
        type(By.id("about"), car.getAbout());


    }

    public void fillCarFormByPosit(Car car) {
        if (isCarFormPresent() == false) return;
        typeLocation(car.getLocat());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        SelectFuel(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeat());
        type(By.id("class"), car.getCarClass());
        GetPosition(By.id("class"));
        typebyPosition(By.id("serialNumber"), car.getSerialNumberPlate());
        type(By.id("price"), car.getPrice());
//        type(By.id("serialNumber"), car.getSerialNumberPlate());

    }

    public void GetPosition(By location) {
        Rectangle rect = (Rectangle) wd.findElement(location).getRect();
        int x = rect.getX();
        int y = rect.getY();

        System.out.println("/" + x + "_" + y + "=rect");
    }

    public void typebyPosition(By location, String text) {
        Rectangle rect = (Rectangle) wd.findElement(location).getRect();
        System.out.println(rect.getY() + "/" + "-rect");
//    int x = 138 ;
//    int y = rect.getY()  + rect.getHeight()-5;
//    System.out.println(x+","+y+"hell");
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(location), 10, 10).click().sendKeys(Keys.BACK_SPACE + text).perform();


    }

    public void typeLocation(String address) {

        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }



    public void SelectFuel(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public boolean isCarFormPresent() {
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(
                                wd.findElement(By.cssSelector("h2")),
                                "details"));
    }
}
