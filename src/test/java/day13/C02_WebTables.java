package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {


    @Test
    public void test01() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        login();


        //table( ) metodu oluşturun
        table ();

        //printRows( ) metodu oluşturun //tr
        printRows();



        /*
        Tabloda <table> tag'ı altında tablonun başlığını gösteren <thead> tagı bulunu. Eğer başlıkta satır(row) varsa
        <thead> tag'ı altında <tr>(satır-row) tagı vardır. Ve başlıktaki sütunlara yani hücrelere(cell) de <th> tag'ı
        ile ulaşılır.
       - Başlığın tablodaki verilere <tbody> tag'ı ile
       - altındaki satırlara(row) <tr> tag'ı ile
        -sütunlara yani hücrelere <td> tag'ı ile ulaşırız
         */
    }

    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List <WebElement> rowList= driver.findElements(By.xpath("//tbody//tr"));
        /*tbody ile tobloya indik sonra tr tagı ile ordaki satırlara ulaştık*/
        System.out.println("body satır sayisi: "+rowList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:rowList) {
            System.out.println(w.getText());
        }
       /* lambda ile::::: rowList.forEach(t-> System.out.println(t.getText()));*/

        //4.satirdaki(row) elementleri konsolda yazdırın.
       WebElement dorduncuSatir= driver.findElement(By.xpath("//tbody//tr[4]")); //başlıklarla ulaştık index girdik
        System.out.println(dorduncuSatir.getText());

    }


    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi= driver.findElements(By.xpath("//thead//tr//th"));
        /*th tag ı ile başlıkdaki sutuna ve oraki cell lere ulaştık*/
        System.out.println("sutun sayisi= "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement headers= driver.findElement(By.xpath("//thead//tr"));   //tr tagı ile başlıktaki satırı aldık
        System.out.println("basliklar : "+headers.getText());

        WebElement tbody= driver.findElement(By.xpath("//tbody"));   //başlığın altındaki body deki tüm veriye ulaştık
        System.out.println(tbody.getText());


    }

    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin

        //Username : manager
        //Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement nameBox= driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions.click(nameBox).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }


}
