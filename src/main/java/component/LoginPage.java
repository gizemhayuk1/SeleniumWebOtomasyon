package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By usernameInput = By.cssSelector("input[id='L-UserNameField']");
    public WebElement username() { return driver.findElement(usernameInput); }

    By passwordInput = By.cssSelector("input[type='password']");
    public WebElement password() { return driver.findElement(passwordInput); }

    By signIn = By.cssSelector("input[id='gg-login-enter']");
    public WebElement signInButon() { return driver.findElement(signIn); }

    By anasayfaLink = By.cssSelector("a[href='https://www.gittigidiyor.com']");
    public WebElement anasayfa() { return driver.findElement(anasayfaLink); }
    
}
