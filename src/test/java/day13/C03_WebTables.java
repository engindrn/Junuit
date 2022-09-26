package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();

        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        int satir=3;
        int sutun=4;

        WebElement cell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        /*dinamik olması için variable isimlerini yazdık direk değerlerde yazılabilir*/
        System.out.println(cell.getText()); //Happy Hotel

        //başlıkta bulunan cell içindeki texti yazdıralım
        int headsatir=1; //başlıkta tak satır var
        int headsutun=3;

        WebElement headCell= driver.findElement(By.xpath("//thead//tr[1]//th[3]"));
        System.out.println(headCell.getText());  //Code

        //Price baslıgındaki tüm numaraları yazdırınız //birden fazla değer döneceği için liste attık
        List<WebElement> price = driver.findElements(By.xpath("//tbody//tr//td[6]"));//burda sadece 1.yi aldı
        for (WebElement w: price) {
            System.out.println(w.getText());
        }


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
