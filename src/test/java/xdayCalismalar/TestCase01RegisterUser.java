package xdayCalismalar;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class TestCase01RegisterUser extends TestBaseBeforeAfter {

    @Test
    public void test01() {
    //   1. Launch browser
    //   2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    //   3. Verify that home page is visible successfully
       String title= driver.getTitle();
        Assert.assertTrue(title.contains("Automation Exercise"));
        System.out.println(title);
//2.yol
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='logo pull-left']")).isDisplayed());

    //   4. Click on 'Signup / Login' button
    WebElement login= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
    login.click();

    //   5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

    //   6. Enter name and email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("engin");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("engdrnnn@gmail.com");

    //   7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

    //   8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

    //   9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("123456789").perform();

        WebElement ddm= driver.findElement(By.xpath("//*[@id='days']"));
        Select options=new Select(ddm);
        options.selectByVisibleText("15");

        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("July"); //bu şekildede seçtik

        WebElement ddmyears = driver.findElement(By.xpath("//select[@id='years']"));
        Select options2 = new Select(ddmyears);
        options2.selectByVisibleText("1987");

        System.out.println(options2.getFirstSelectedOption().getText());  // 1987   seçili optionu verir

        List<WebElement> ddmList= options2.getOptions();

        for (WebElement w:ddmList) {
            System.out.println(w.getText());
        }
        /*lambda ile yazdırma
        ddmlist.forEach(t-> System.out.println(t.getText()));*/

    //   10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

    //   11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

    //   12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Faker faker=new Faker();
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
            sendKeys(faker.company().name()).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).
            sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
            sendKeys("Canada").sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB).
            sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys("123645").sendKeys(Keys.TAB).
            sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
                                                                   //   13. Click 'Create Account button'

    //   14. Verify that 'ACCOUNT CREATED!' is visible

        Assert.assertTrue( driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());

    //   15. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    //   16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='engin']")).isDisplayed());

    //   17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

    //   18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]")).isDisplayed());

        //2.yol
      WebElement visible=  driver.findElement(By.xpath("//*[text()='Delete Account'])[2]"));
      Assert.assertTrue(visible.isDisplayed());

        //3.yol
        String container = driver.findElement(By.xpath("(//*[@class='container'])[2]")).getText();
        Assert.assertFalse(container.contains("ACCOUNT DELETED!"));


    }

}
