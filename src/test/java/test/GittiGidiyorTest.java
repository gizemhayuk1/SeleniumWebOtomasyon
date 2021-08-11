package test;

import base.Base;
import component.BasketPage;
import component.LoginPage;
import component.MainPage;
import component.ProductPage;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class GittiGidiyorTest extends Base {
    private static final Logger log = Logger.getLogger(Base.class);
    

    @Before
    public void beforeMethod(){
        super.beforeMethod();
        driver.get("https://www.gittigidiyor.com");
    }
    
    @After
    public void afterMethod(){
        super.afterMethod();
        driver.quit();
    }
    
    
	@Test
    public void gittiGidiyorTest() throws InterruptedException, AWTException {
    	BasicConfigurator.configure();
    	
        MainPage mp = new MainPage(driver);
        LoginPage lp = new LoginPage(driver);
        ProductPage pp = new ProductPage(driver);
        BasketPage bp = new BasketPage(driver);
        Actions action = new Actions(driver);
        action.moveToElement(mp.girisYapButon()).click().build().perform();
        
        //anasayfa kontrolü
        String mainPageTitle = driver.getTitle();
        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",mainPageTitle);
        
        Thread.sleep(2000);
        mp.girisYapHoverButon().click();
        Thread.sleep(2000);
        lp.username().sendKeys("testiniumgizem@gmail.com");
        Thread.sleep(2000);
        lp.password().sendKeys("Gizem.123");
        Thread.sleep(1000);
        lp.signInButon().click();
        
        
        if(driver.findElements(By.xpath("//div[title='Hesabım']")).size() != 0) {
            log.info("Login başarılı!");
        }
         else{	 
        	 log.info("Login başarısız");
        	 lp.anasayfa().click();
        }
        
        Thread.sleep(2000);
		mp.searchBarFunc().sendKeys("bilgisayar");
		mp.searchButonFunc().click();
        Thread.sleep(1000);
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        pp.secondPageButtonFunc().click();
        Thread.sleep(2000);

        if(pp.secondPageButtonFunc().getAttribute("class").contains("current")){
             log.info("Second page is opened");
        }
        else{
        	 log.info("Second page is not opened");
        }
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 400)");
        pp.thirdProductFunc().click();
        Thread.sleep(3000);

        // Ürün bilgisiyle tutar bilgisi alınır ve txt dosyasına yazdırılır.
        String productName = pp.productNameFunc().getText();
        String productPrice = pp.productPriceFunc().getText();
        
        String productInfo = productName + ' ' + productPrice;
        File productInfoFile = new File("productInfo.txt");

        FileWriter fw;
		try {
			fw = new FileWriter(productInfoFile);
			fw.write(productInfo);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 600)");
        pp.addToCardButtonFunc().click(); //ürün sepete eklenir.
        Thread.sleep(3000);
        
        //sepete gidilir.
        bp.basketHoverButon().click();
        
        //sepetteki fiyat ile ürünün fiyatı karşılaştırılır.
        String productBasketPrice = bp.totalPriceFunc().getText();
        if(productBasketPrice.equals(productPrice)){
            log.info("Product price is equal to product basket price.");
        }

        else{
        	log.info("Product price is NOT equal to product basket price.");
        }
        
        Thread.sleep(2000);
        
        //ürünün adedi artırılır.
        Select productAmountFunc = new Select(bp.productAmountFunc());  
        productAmountFunc.selectByValue("2");  
        
        
        Thread.sleep(2000);
        
        String productAmountValue = bp.increaseAmountFunc().getText();
        Assert.assertEquals("2",productAmountValue);

        
        //ürün silinir.
        bp.btnDeleteFunc().click();
        Thread.sleep(2000);
        
        //sepetin boş olup olmadığı kontrol edilir.
        if(driver.findElements(By.cssSelector("a[class='btn-delete btn-update-item']>i")).isEmpty())
        {
        	 log.info("Basket is empty");
        }
        
        else{
         	log.info("Basket is NOT empty.");
        }
        
}
	

}