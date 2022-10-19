package xdayCalismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //google GİT
        driver.get("https://www.google.com");

        //CEREZLER
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();

        //SAYFA BAŞLIĞININ GOOGLE OLD TEST EDİN
       String actualTitel= driver.getTitle();
       String expectedTitle= "Google";
       if(actualTitel.contains(expectedTitle)){
           System.out.println("test passed");
       }else System.out.println("test faild");

       //arama cubuguna "Nutella" yazdır arat
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella"+ Keys.ENTER);

        //bulunan sonuç sayısını yazdirin
        String sonucYazisi= driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println(sonucYazisi);

        String [] sayi= sonucYazisi.split(" ");
        System.out.println(sayi[1]);

        //sonuc sayisinin 10 milyondan fazla olld test ediniz
       /* String sonucSayisi=sayi[1];
        System.out.println(sonucSayisi);
        int sonuc = Integer.parseInt(sonucSayisi);
        System.out.println(sonuc);


        if(sonuc>10.000000){
            System.out.println("test passed");
        }else System.out.println("test faild");*/


    }
}
