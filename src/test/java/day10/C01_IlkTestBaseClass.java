package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {
    //extends yaptık parant olan clasımızdaki methodlara ulşacz

    @Test
    public void test01() {
        driver.get("https://www.amazon.de");
    }
}
