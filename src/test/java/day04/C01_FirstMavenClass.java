package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C01_FirstMavenClass {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.de");

        //çerezleri kabul ettik
        driver.findElement(By.id("sp-cc-accept")).click();  //bir defa kullanacaksak webelemente atamya gerek yok
        
      // 2- arama kutusunu locate edelim
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

      // 3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

      // 4- Bulunan sonuc sayisini yazdiralim
       WebElement aramaSonucu= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        System.out.println("arama sonucu :" +aramaSonucu.getText());

        String [] bulunanUrunSayisi = aramaSonucu.getText().split(" ");
        System.out.println(bulunanUrunSayisi[2]);



        // 5- Ilk urunu tiklayalim

       // driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();   ilk ürünü xpath ile unique yapıp aldık

        List<WebElement> urunler= driver.findElements(By.className("s-image"));    //bulunan ürünleri liste atıp ilkini aldık
        WebElement ilkUrun = urunler.get(0);
        ilkUrun.click();


      // 6- Sayfadaki tum basliklari yazdiralim

        System.out.println(driver.findElement(By.xpath("//h1")).getText());

    }
}
