package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

     static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Amazon sayfasına gidelim
        driver.get("https://www.amazon.de");      //test methodlarımızı bağımsız çalıştırabilmek için beforeClassa yazdık
                                               //bu şekilde herhangi bir test methodunu çalıştırsakta ilk bu çalışacağı
                                           //için test etmek istefiğimiz sayfa açılacak.test methodlarının hepsine yazmayız
        //cookies
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    // 4 farklı test methodu oluşturalım


    @Test
    public void method1(){
        // a-Url'nin amazon içerdiğini test edelim
      String expectedUrl= "https://www.amazon.de";
      String actualUrl = driver.getCurrentUrl();

      //  Assert.assertEquals(expectedUrl,actualUrl); birebir aynın olmadığı için falid https://www.amazon.de  expected
      //                                                                                https://www.amazon.de/   actual

      Assert.assertTrue(expectedUrl.contains(actualUrl));  //içerdiği için passed olur

    }

    @Test
    public void method2(){
        // b-Title'in facebook içermediğini test edelim
    String expectedTitle= "facebook";
    String actuelTitle= driver.getTitle();

    Assert.assertFalse(actuelTitle.contains(expectedTitle));

    }

    @Test
    public void method3(){
        // c- sol üst köşede amazon logosunun göründüğünü test edelim

        WebElement logo =driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }

    @Test
    public void method4(){
        // d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl= "www.facebook.com";
        String actuelUrl= driver.getCurrentUrl();

        Assert.assertFalse(expectedUrl.contains(actuelUrl));  //burda beklenenle mevcut url in eşit olamdığını idda ettik
     // Assert.assertNotEquals(expectedUrl,actuelUrl); // bu kodda passed olur expected ile actuel in eşit olmadığını "".

    }
}
