package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdDownHandle {




    WebDriver driver;

    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin.            // her test methodlarınmı ayrı ayrı çalıştımalıyız
        driver.get("https://www.amazon.de");                 //aksi halde her methodda yeni before classında
        //cookies                                            //belirtilen sayfayı her test için ayrı açıyor
        driver.findElement(By.id("sp-cc-accept")).click();
    }
    @After
    public void tearDown (){
        //driver.close();
    }

    @Test
    public void method1(){
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        // xpath option (tagName) kullanarak dropDown menüsünü locate edip elemanlara ulaştık ve bunları liste attık
        System.out.println(drops.size());  // kaç elemanı var size ile aldık //48

        for (WebElement w:drops) {
            System.out.println(w.getText());
        }

        int dropDownList = drops.size();   //sitede bulumam dropdown menüsünün elman sayısını size ile almıştık
        int expectedSayi = 45;

        Assert.assertNotEquals(expectedSayi,dropDownList);
    }


    @Test
    public void method2(){
     //   1.Kategori menusunden Books seceneginisecin ve search edin
      WebElement menu=  driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
      menu.sendKeys("Bücher");

      driver.findElement(By.id("nav-search-submit-button")).click();

     //   2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

     //   3.Bulunan sonuc sayisini yazdirin
      WebElement snc=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
      String sonucYazisi= snc.getText();
        System.out.println(sonucYazisi);

        String [] sonucYazisiArrayde = sonucYazisi.split(" ");
        System.out.println(sonucYazisiArrayde[4]);



     //   4.Sonucun Java kelimesini icerdigini testedin
       String expectedWord = "Java";
       String accualSonucYazisi= snc.getText();

        Assert.assertTrue(accualSonucYazisi.contains(expectedWord));
    }
}
