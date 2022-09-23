package day10;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_TestBaseBeforeClassAfterClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() {
        driver.get("https://www.amazon.de");
    }
}
