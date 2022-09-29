package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException {

        // Amazon'a gidip, "Nutella" aratalım.
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);



// Belirli bölgelerin ekran görüntüsünü almak istersek o bölgeyi locate etmek gerekir.
// Aynı zamanda belirli bölgeyi çekmek istediğimizde alttaki objeyi oluşturmaya gerek yok ! Arasındaki tek fark bu !
// TakesScreenshot ts= (TakesScreenshot) driver;//Sadece Web elementin resmini alacaksak TakeScreenShot classını kullanmama gerek yok

        // Ve sonuç yazısının sayısının olduğu, web elementin fotoğrafını ekleyelim.
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File nutellaAramaSonucu = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        /*Locate ettiğimiz webelementi direk geçici bir file'a atıp FileUtils ile kopyalayıp yolunu(path) belirtiriz*/
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));

    }
}
