package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test

    public void test01() {
        //amazona gidiniz
        driver.get("https://www.amazon.com");

        //tum cookiesleri listeleyiniz
        Set<Cookie> tumCookies= driver.manage().getCookies();
        System.out.println(tumCookies);  //hepsini yazdırdı

        int sayac = 1;
        for (Cookie w:tumCookies) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }

        //sayfadaki cookieslerin sayısının 5 den fazla old test edin
        int cookieSayisi= tumCookies.size();   //kaç adet old ulduk
        System.out.println(cookieSayisi);   //8
        Assert.assertTrue(cookieSayisi>5);  //AssertTrue methoduyla beşten fazla old bişdiğimz için true dedik

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookies) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");   //cookie claasından bir obje oluşturduk
        driver.manage().addCookie(yeniCookie);
        Set<Cookie> tumCookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Cookie isim =driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains("isim"));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());

    }
}
