package manager;

import com.sun.javafx.image.impl.ByteIndexed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {


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
        type(By.xpath("//input[@id='dates']"), "7/19/2023 - 7/29/2023");
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

    public void fillSeachForm(String city, String dataFrom, String dataTo) {
        fillCity(city);
//        selectPeriodDaysDatePicker(dataFrom, dataTo);
//        SelectPeriodDataPic(dataFrom, dataTo);
        SelectPeriodDataPicYears(dataFrom,dataTo);
    }

    public void fillCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
    }

    public void selectPeriodDays(String dataFrom, String dataTo) {

        type(By.id("dates"), dataFrom + " - " + dataTo);
        click(By.id("city"));

    }

    public void submitFormSeach() {
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public void selectPeriodDaysDatePicker(String dataFrom, String dataTo) {
        click(By.id("dates"));
        String[] startDate = dataFrom.split("/");
        String[] endDate = dataTo.split("/");
//        click(By.xpath("//div[.=' "+startDate[1]+" ']"));
//        click(By.xpath("//div[.=' "+endDate[1]+" ']"));
//        pause(1000);
        String locatorStartdate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEnddate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartdate));
        pause(100);
        click(By.xpath(locatorEnddate));

    }

    public void SelectPeriodDataPic(String dateFrom, String dateto) {
        click(By.id("dates"));
        int fromNowtoStart = 0, fromstartToEnd = 0;
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateto.split("/");
        fromstartToEnd = Integer.parseInt(endDate[0]) - Integer.parseInt(startDate[0]);

        if (LocalDate.now().getMonthValue() != Integer.parseInt(startDate[0])) {
            fromNowtoStart = Integer.parseInt(startDate[0]) - LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < fromNowtoStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }

        String locatorStartdate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEnddate = String.format("//div[.=' %s ']", endDate[1]);

        click(By.xpath(locatorStartdate));
        pause(100);

        for (int i = 0; i < fromstartToEnd; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }

        click(By.xpath(locatorEnddate));
    }

    public void SelectPeriodDataPicYears(String dateFrom, String dateto) {

        LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse(dateto, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate nowDate = LocalDate.now();

        String locatorStartdate = String.format("//div[.=' %s ']", startDate.getDayOfMonth());
        String locatorEnddate = String.format("//div[.=' %s ']", endDate.getDayOfMonth());
        click(By.id("dates"));
        int startToEndMonth = startDate.getYear() - nowDate.getYear() == 0 ?
                startDate.getMonthValue() - nowDate.getMonthValue() :
                12 - nowDate.getMonthValue() + startDate.getMonthValue();
        for (int i = 0; i < startToEndMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorStartdate));
        pause(100);
        startToEndMonth=endDate.getYear()-startDate.getYear()==0?endDate.getMonthValue()-startDate.getMonthValue():
                12 - startDate.getMonthValue() + endDate.getMonthValue();
        for (int i = 0; i < startToEndMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEnddate));

    }

}


