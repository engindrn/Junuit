package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidak testleri yapin
          driver.get("https://www.bestbuy.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method1(){
      //  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actuelUrl= driver.getCurrentUrl();

        Assert.assertTrue(expectedUrl.contains(actuelUrl));
       //2.yol: Assert.assertEquals(expectedUrl,actuelUrl);

    }

    @Test
    public void method2(){
        //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
     String expectedTitle= "Rest";
     String actualTitle= driver.getTitle();

     Assert.assertFalse(expectedTitle.contains(actualTitle));


    }

    @Test
    public void method3(){
        //  ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

       // Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
        // TEK SATIRDA DA YAPABİLİRİZ AMA CLEAN CODE AÇISINDAN WebElement KULLANMAK DAHA İYİ

    }

    @Test
    public void method4(){
        //  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement link= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(link.isDisplayed());
    }
}
