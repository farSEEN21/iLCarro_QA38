package manager;

import models.User;
import models.UserLombok;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HelpUser extends HelperBase {


    public HelpUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {

        wd.findElement(By.xpath("//a[.=' Log in ']")).click();

    }

    public void openRegistationForm() {
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String psd, String email) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), psd);



    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());


    }

    public void fillRegistrationForm(User user) {
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastname());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());
        clickCheckbox();
    }

    public void clickCheckbox() {
        System.out.println("Hello=");
//        var 1  click(By.cssSelector("label[for='terms-of-use']"));
//        var 2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
//        var3
//        Rectangle rect = (Rectangle) wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
//        int x = rect.getX() + 5;
//        int y = rect.getY() + rect.getHeight() / 4;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();

    }

    public void fillRegistrationForm(UserLombok user) {
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastname());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());
        //  click(By.cssSelector("label[for='terms-of-use']"));
        clickCheckbox();
    }


    public void submitLogin() {
        wd.findElement(By.xpath("//button[@type='submit']")).submit();

    }

    public void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[@type='button']"));
    }

    public boolean isLoggedSuccess() {
        return isElementPresent(By.xpath("//h2[contains(text(), 'success')]"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
    }



}
