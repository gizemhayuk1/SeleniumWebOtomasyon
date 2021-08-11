package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;


public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Logger logger;

    public void beforeMethod(){
       System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver\\chromedriver.exe");
       ChromeOptions ops = new ChromeOptions();
       ops.addArguments("--disable-notifications");
       driver = new ChromeDriver(ops);
       wait = new WebDriverWait(driver,20);
       driver.manage().window().maximize();
       }

       public void afterMethod(){
        driver.quit();
    }
}

