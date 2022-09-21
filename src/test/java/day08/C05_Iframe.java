package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_Iframe {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void Test1() {

        driver.get("https://html.com/tags/iframe/");

           /*
    Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse bu video'yu direk locate edip
    çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
    Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip
    çalıştırabiliriz.  sitede tag name ile //iframe şeklinde aratıp sitedeki bütün iframelere ulaştık
     */
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));    //listten index ile vidoyu aldık
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click(); //play tuşunu locate edip tıkladık



    }
}