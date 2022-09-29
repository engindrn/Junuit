package xdayCalismalar;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C04_P03FakerIle extends TestBaseBeforeAfter {
    // go to the URL
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın (hayvan emojisini seçin)
    // tüm hayvan emojilerine tıklayın
    // formu doldurun (dilediğinizi yazabilirsiniz)
    // apply butonuna tıklayın

    @Test
    public void test01() {
        // go to the URL
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> hayvanList = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        hayvanList.forEach(t -> t.click());
        System.out.println(hayvanList.size());
        driver.switchTo().defaultContent();
        // formu doldurun (dilediğinizi yazabilirsiniz)
        WebElement isim = driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(isim).sendKeys("Akin").sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).perform();
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[@class='mdl-button mdl-js-button mdl-button--raised mdl-button--colored']")).click();
    }
}
