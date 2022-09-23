package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){

    }
    @Test
    public void test01(){
        //1- Amazon Sayfasina girelim,Window handle değerini alalım
        driver.get("https://www.amazon.com");
       String amazonWidowHandle= driver.getWindowHandle();

          /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driver'in window handle değerini string bir değişkene atarız
        Sonrasında farklı bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
         */

        //2- Url'nin amazon içerdiğini test edelim
       String actualUrl= driver.getCurrentUrl();
       String expectedUrl= "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni window açma
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle= driver.getWindowHandle();

        //4- title'in Best Buy içerdiğini test edelim
       String bestBuyTitle= driver.getTitle();
       String expecdedTitle= "Best Buy";
       Assert.assertTrue(bestBuyTitle.contains(expecdedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWidowHandle);         //amazonun handle değerini girerek amazona döndük
      WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
      searchBox.sendKeys("java"+ Keys.ENTER);
      //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER); *tek satırdada yapılabilir

        //6- Arama sonuclarının java içerdiğini test edelim
        driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String actualSonuc= driver.getTitle();    //1-48 of over 6,000 results for "java" Stringin içinde bu VARRRR
        Assert.assertTrue(actualSonuc.contains(arananKelime));
        System.out.println(actualSonuc);

        //6-1 arama sonucu kaç java içeren ürün bulundu
        String [] adet= actualSonuc.split(" ");
        System.out.println(adet[2]);

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
      WebElement logo=  driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
      Assert.assertTrue(logo.isDisplayed());

      //  Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());


    }
}
