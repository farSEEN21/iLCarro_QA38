package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.text;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openFormCar(){
        pause(5000);
click(By.xpath("//a[.=' Let the car work ']"));
    }


    public void FillForm(Car car) {
        if(isCarFormPresent()==false) return;
typeLocat(car.getLocat());
fillform(By.id("make"),car.getMake());
fillform(By.id("model"),car.getModel());
fillform(By.id("year"),car.getYear());
SelectFuel(By.id("fuel"), car.getFuel());
fillform(By.id("seats"),car.getSeat());
fillform(By.id("class"),car.getCarClass());
fillform(By.id("serialNumber"),car.getSerialNumberPlate());
fillform(By.id("price"),car.getPrice());
fillform(By.id("about"),car.getAbout());


    }

public void typeLocat(String addres){

    fillform(By.id("pickUpPlace"),addres);
    pause(3000);
    click(By.cssSelector("div.pac-item"));


}

public void SelectFuel(By locator, String option){
new Select(wd.findElement(locator)).selectByValue(option);
}
public boolean isCarFormPresent(){
    return new WebDriverWait(wd,10).until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "details"));
}
}
