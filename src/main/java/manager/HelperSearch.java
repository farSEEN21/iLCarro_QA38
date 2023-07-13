package manager;

import com.sun.javafx.image.impl.ByteIndexed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void typeCitySeach(String address) {
        type(By.id("city"), address);
        click(By.cssSelector("div.pac-item"));
    }
    public void openFormCar() {
        pause(5000);
        click(By.xpath("//a[.=' Search ']"));
    }


    public void typeDate(String s) {
        type(By.xpath("//input[@id='dates']"),"7/19/2023 - 7/29/2023" );
    }

    public void findDate() {
        click(By.xpath("//input[@id='dates']"));
       // int s=wd.findElements(By.cssSelector("td[aria-disabled='true']")).size();
        click(By.xpath("//td[@class='mat-calendar-body-cell mat-calendar-body-active ng-star-inserted']"));
        click(By.xpath("//td[@class='mat-calendar-body-cell ng-star-inserted'][2]"));
 }
 public void AnyMonthDate() {
        click(By.xpath("//input[@id='dates']"));
        click(By.xpath("//div[@class='mat-calendar-arrow']"));
        click(By.xpath("//div[@class='mat-calendar-body-cell-content mat-calendar-body-today']"));
        click(By.xpath("//td[@class='mat-calendar-body-cell ng-star-inserted'][2]"));
       // int s=wd.findElements(By.cssSelector("td[aria-disabled='true']")).size();
        click(By.xpath("//td[@class='mat-calendar-body-cell mat-calendar-body-active ng-star-inserted']"));
        click(By.xpath("//td[@class='mat-calendar-body-cell ng-star-inserted'][2]"));
 }
}
