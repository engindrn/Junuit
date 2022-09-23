package day10;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test

    public void test01() {
        //amazona gidelim
        driver.get("https://www.amozon.com");
        driver.navigate().refresh();

        // - Account&list menüsünün üzerine gidiniz
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver);   //Actionns classdan driver paramametreli bir obje oluşturudk
        actions.moveToElement(accountList).perform();  //obje sayesinde movetoElement methodunu kullandık parametre olr locate
                                                       //ettiğimiz webElementi koyduk


          /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable(etkileşim) exception'ı fırlatır
        (element var ama bulamıyor manasına gelebilir)
         */

        //creat list e tıklayınız
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
