package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //   * https://www.youtube.com adresine gidin
        driver.get("https://youtube.com");
        //cookies
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();
    }

    @AfterClass
    public static void tearDown (){
       // driver.close();
    }

    //  * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void method1(){
     //  * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     String expectedTitle= "YouTube";
     String actuelTitle= driver.getTitle();

      //  Assert.assertTrue(expectedTitle.contains(actuelTitle));
        Assert.assertEquals(expectedTitle,actuelTitle);

    }
    @Test
    public void test2(){
    //* imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }


    @Test
    public void method3(){
        //  * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.name("search_query"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void method4(){
    //  * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String unExpectedTitle = "youtube";
        Assert.assertNotEquals(unExpectedTitle,actualTitle);

        //Assert.assertFalse(actualTitle.contains(unExpectedTitle));
    }
}
