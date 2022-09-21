package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {

    WebDriver driver;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void method1(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option = new Select(ddm);
        option.selectByIndex(1);

                    //2. yol
             //WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
             // ddm.sendKeys("Option 1");  bu şekilde de dropdowm menüden istediğimizi seçtiririz

        System.out.println(option.getFirstSelectedOption().getText()); // Option 1 yazdırdık


        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        option.selectByValue("2");
        System.out.println(option.getFirstSelectedOption().getText());


        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        option.selectByVisibleText("Option 1");
        System.out.println(option.getFirstSelectedOption().getText());

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmlist= driver.findElements(By.xpath("//option")); //normal yolla dd menüdeki elementleri koyduk

       // List<WebElement> ddmlist=select.getOptions(); //getOptions() methoduyla dropDown menüdeki tüm elementlerin listesini koyduk


                    //for each ile yazdırma
        for (WebElement w:ddmlist) {
            System.out.println(w.getText());
        }
                   //lambda ile yazdırma
        //ddmlist.forEach(t-> System.out.println(t.getText()));


        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse false yazdırın.
        System.out.println("dropDown size: "+ddmlist.size());
        if (ddmlist.size()==4){
            System.out.println("true");
        }else System.out.println("false");

        Assert.assertNotEquals(ddmlist.size(),4); //

    }
}
