package day07;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDownSelect {

    WebDriver driver;
    Select options;     //her method dan ulaşabilmek için class seviyesinde objemizi oluşturduk

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown (){
       // driver.close();
    }
    @Test
    public void method1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45 oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        options = new Select(ddm);  //Select classından bir obje oluşturup locate ettiğimiz
                                        // WebElementini (ddm) parametre olr ekledik

        List<WebElement> ddmList= options.getOptions();  //dropdown menünün elemanlarına ulaşmak için
        /*
        Dropdown menuye ulasmak için Select classından bir obje oluştururuz
        ve locate ettiğimiz dropdown weblementini Select classına tanımlarız
        ve getOption methodunu kullanarak dropdown'u bir list'e atarak dropdawn menunun bütün elemanlarının
        sayısına ulaşabiliriz
         */
        int expectedSayi= 45;
        int actualSayi= ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualSayi);

    }

    @Test
    public void method2(){
      // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        options= new Select(ddm);
        options.selectByVisibleText("Books");
        //options.deselectByIndex(5);
        //options.selectByValue("search-alias=stripbooks-intl-ship"); Eğer dropdown menusundeki optiona value ile ulaşmak istersek bu methodu kullanırız

         /*
        Dropdown menude seçtiğimiz optiona ulaşmak istersek select.getFirstSelectedOption()
        methodunu kullanırız
         */
        System.out.println(options.getFirstSelectedOption().getText());    //Books -seçili elementi yazdırır

      // 2.Arama kutusuna Java yazin vearatin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

      // 3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

      // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}
