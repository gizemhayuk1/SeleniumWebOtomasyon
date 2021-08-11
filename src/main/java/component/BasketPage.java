package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasketPage {

    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    By basketHover = By.xpath("//a[contains(text(),'Sepete Git')]"); 
    public WebElement basketHoverButon(){ return driver.findElement(basketHover); }
    
    By productAmount = By.xpath("//select[@class='amount']");
    public WebElement productAmountFunc() { return driver.findElement(productAmount); }
    
    By increaseAmount = By.cssSelector("option[value='2']");
    public WebElement increaseAmountFunc() { return driver.findElement(increaseAmount); }
    
    By totalPrice = By.cssSelector("div[class='total-price']");
    public WebElement totalPriceFunc() { return driver.findElement(totalPrice); }
    
    By btnDelete = By.cssSelector("a[class='btn-delete btn-update-item']>i");
    public WebElement btnDeleteFunc() { return driver.findElement(btnDelete); }
    

    
}


