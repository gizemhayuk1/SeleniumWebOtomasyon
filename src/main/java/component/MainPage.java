package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
       
    }

    By girisYap = By.cssSelector("div[title='Giriş Yap']");
    public WebElement girisYapButon()   {  	return driver.findElement(girisYap);   }

    By girisYapHover = By.cssSelector("a[href='https://www.gittigidiyor.com/uye-girisi?s=1']"); 
    public WebElement girisYapHoverButon(){ return driver.findElement(girisYapHover); }
    
    By searchBar = By.cssSelector("input[data-cy='header-search-input']");
    public WebElement searchBarFunc() { return driver.findElement(searchBar); }

    By searchButon = By.cssSelector("button[data-cy='search-find-button']");
    public WebElement searchButonFunc() { return driver.findElement(searchButon); }
    
    By hesapIcon = By.cssSelector("div[title='Hesabım']");
    public WebElement hesabim() { return driver.findElement(hesapIcon); }
}