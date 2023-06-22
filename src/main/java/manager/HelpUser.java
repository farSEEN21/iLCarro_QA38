package manager;

import models.User;
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
        wd.findElement(By.xpath("//button[.='Ok']")).submit();
        //click(By.xpath("//button[.='Ok']"));

    }public void fillformYalla(User user) {
        fillform(By.xpath("//input[@id='email']"), user.getEmail());
        fillform(By.xpath("//input[@id='password']"), user.getPsw());
        click(By.cssSelector("button[type='submit']"));
        pause(500);
        wd.findElement(By.xpath("//button[.='Ok']")).submit();
        //click(By.xpath("//button[.='Ok']"));

    }

public void logout(){
        wd.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
}

}
