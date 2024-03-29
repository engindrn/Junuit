package day05;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;     //diğer methodlardan da kullanabilmek için class seviyesinde objemizin oluşturduk

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();                      //burda atama yaptik class level a gitti artik diger scoplarda da kullanilabilir
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1(){
        //1 defa before methodu çalışır
        driver.get("https://wwww.amazon.com");
        //1 defa da after methodu çalışır
    }

    @Test
    public void method2(){
        //1 defa before methodu çalışır
        driver.get("https://www.techproeducation.com");
        //1 defa da after methodu çalışır
    }

    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }

    @After
    public void tearDown(){
        driver.close();

    }
}


/*@Before : Önce ;
 @After : Sonra Demek
 @Test kısmında yazdığımız methodlar; çalışmaya başlamadan önce
@Before yazan method çalışır; sonra kendisi çalışır ve en son olarak ta @After da yazılan method çalışır...
Bu durum her @Test methodun da aynı şekilde devam eder. @After ve @Before methodlarının nerde yazıldığının önemi yoktur (edited)
 */