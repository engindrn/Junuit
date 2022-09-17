package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {


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
        driver.close();
    }

    @Test
    public void method1() throws InterruptedException {
      //  https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

      // Cookies'i kabul edin
     WebElement cookies= driver.findElement(By.xpath("//*[@title='Temel ve isteğe bağlı çerezlere izin ver']"));
     cookies.click();

      // "Create an Account" button'una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

      // "radio buttons" elementlerini locate edin
       WebElement kadin= driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
       WebElement erkek= driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
       WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));

      // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()){
            erkek.click();
        }


        Thread.sleep(3000);
        kadin.click();

    }
}
