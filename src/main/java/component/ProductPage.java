package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By productTitle = By.xpath("(//h3[@class='product-title ']//span)[1]");
    public WebElement productTitleFunc() { return driver.findElement(productTitle); }

    By secondPageButton = By.xpath("//a[text()='2']");
    public WebElement secondPageButtonFunc() { return driver.findElement(secondPageButton); } // class current

    By thirdProduct = By.xpath("//ul[@class='catalog-view clearfix products-container']/li[3]");
    public WebElement thirdProductFunc() { return driver.findElement(thirdProduct); }

    By addToCardButton = By.xpath("//div[@id='sp-addbasket-button']//button[@id='add-to-basket']");
    public WebElement addToCardButtonFunc() { return driver.findElement(addToCardButton); }

    By productName= By.cssSelector("h1[id='sp-title']");
    public WebElement productNameFunc() { return driver.findElement(productName); }
    
    By productPrice= By.xpath("//div[@id='sp-price-container']/following::div[@id='sp-price-lowPrice']");
    public WebElement productPriceFunc() { return driver.findElement(productPrice); }
    

    

}
