package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Faker extends TestBaseBeforeAfter {

    @Test
    public void test01 () {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        WebElement isimBox= driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Faker faker=new Faker();  //Faker clasından objemizi üretip sahte bilgiler üretmek için kullancağız
        Actions actions= new Actions(driver);  //bu bilgileri sayfaya göndermek ve sayfada gezinmek için action objesi lazm
        String email = faker.internet().emailAddress();// Aynı mail adresini girmesi için String bir değişkene atama yaptık
        //PASWORD İÇİNDE AYNI ŞEY YAPILMALI ŞİFRE ONAYI İÇİN TEKRAR GİRECEKSEK BİR VARİABLE ATAMA YAPARAK KULLANILMALI

        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */

        actions.click(isimBox).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("15").sendKeys(Keys.TAB)
                .sendKeys("Tem").sendKeys(Keys.TAB).sendKeys("1987").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

    }
}
