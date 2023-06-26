package manager;

import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
//        click(By.cssSelector("button[type='submit']"));
//        pause(500);
//        wd.findElement(By.xpath("//button[.='Ok']")).submit();
//        //click(By.xpath("//button[.='Ok']"));


    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());
//        click(By.cssSelector("button[type='submit']"));
//        pause(500);
//       // wd.findElement(By.xpath("//button[.='Ok']")).submit();
//         click(By.xpath("//button[.='Ok']"));

    }
public void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastname());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());
        click(By.cssSelector("label[for='terms-of-use']"));
}
public void fillRegistrationForm(UserLombok user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastname());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPsw());
        click(By.cssSelector("label[for='terms-of-use']"));
}
//    public void logout() {
//        wd.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
//    }

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
//    public void precondition(){
//
//        if (isElementPresent(By.xpath("//a[contains(text(),'Logout')]"))) {
//            logout();
//        }
//
//    }
//
//
//    public void postcondition(){
//        logout();
//    }
//    public void Login(User user){
//     logIn();
//        fillformYalla(user);
//
//    }
//
//
//    public void openregform(){
//        wd.findElement(By.xpath("//a[.=' Sign up ']")).click();
//    }
//
//    public void regFillForm(User user){
//        type(By.xpath("//input[@id='name']"), user.getName());
//        type(By.xpath("//input[@id='lastName']"), user.getLastname());
//        type(By.xpath("//input[@id='email']"), user.getEmail());
//        type(By.xpath("//input[@id='password']"), user.getPsw());
//click(By.cssSelector("label[for='terms-of-use']"));
//        pause(500);
//        click(By.cssSelector("button[type='submit']"));
//        pause(500);
//    }


}
