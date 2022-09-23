package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test

    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan bölümün uzerinde sag click yapalim
      WebElement sagTiklancakAlan= driver.findElement(By.id("hot-spot"));
        Actions actions= new Actions(driver);
        actions.contextClick(sagTiklancakAlan).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
       String alertText= driver.switchTo().alert().getText();
       String expectedText= "You selected a context menu";
        Assert.assertEquals(alertText,expectedText);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //alerti accept ettik
       driver.switchTo().alert().accept();

       //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        /*yeni sekmede açılan sayfada işlem yapabilmemiz için o sayfaya geçiş yapmamız gerekir
         bunun içinde handle değerine ihtiyacımız var ama sayfa kendi açıldığı için handle kodumuz yok
          Handle değerini bulabilmek için driver.getWindowHandles() methodunu bir ArrayListe atıp sayfaların handle
          değerlerine ulaşıp ordan index ile gitmek istediğimiz sayfanın indexsini yazıp gideceğiz
          sonra sayfadaki işlemi yapabileceğiz
          */
        List <String> windowList =new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowList);// görmek için yazdırdık
        driver.switchTo().window(windowList.get(1));   //listeki handle değerini yazarak o sayfaya geçtik

          WebElement text= driver.findElement(By.xpath("//h1"));
          String actualText= text.getText();
          String expected="Elemental Selenium";
          Assert.assertTrue(actualText.contains(expected));

         //2. Assert.assertTrue(text.isDisplayed());
        //3.yolAssert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

    }
}
