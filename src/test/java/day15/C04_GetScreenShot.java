package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim tum sayfanın resmini alalim
        driver.get("https://bestbuy.com");
        /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */
        TakesScreenshot ts = (TakesScreenshot) driver;  //objemizi oluşturduk.casting yaptık
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE); //geçici bir file aldık Screenshot u
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg")); //sonra kaydettik

    }
}
/*    localdatetime classından obfemizi oluşturduk ve TestBase clasımıza koyduk her ekran resmin için yeni isim verirken
kullanıyoruz böylelikle eski resmi silmeden farklı isimle katdediyoruz.

         LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formater);    */