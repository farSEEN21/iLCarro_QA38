package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpUser extends HelperBase {


    public HelpUser(WebDriver wd) {
        super(wd);
    }

    public void logIn() {
        wd.findElement(By.xpath("//a[.=' Log in ']")).click();

    }

    public void fillformYalla(String psd, String email) {
        fillform(By.xpath("//input[@id='email']"), email);
        fillform(By.xpath("//input[@id='password']"), psd);
        click(By.cssSelector("button[type='submit']"));
        pause(500);
        click(By.xpath("//button[.='Ok']"));

    }


}
