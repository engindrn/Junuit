package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        //Amazon sayfasına gidelim
        driver.navigate().to("https://www.amazon.com");

        //Aşağıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement carrers = driver.findElement(By.xpath("//*[text()='Careers']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);  //sona locate ettiğimiz webElementi yazdık

        //Carrers butonuna js ile click yapalım
        jse.executeScript("arguments[0].click();",carrers);

        //ana sayfaya geri döndük
        driver.navigate().back();
    }
}
