package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
        TestNG test methodlarini isim sirasina gore calistirir
        eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
        o zaman test methodlarina oncelik yani priority tanimlayabiliriz

        priority kucukten buyuge calisir
        eger bir test methoduna priority degeri atanmamissa default olarak priority=0 kabul edilir.
     */
    @Test(priority = -5)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(priority = -2)
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void facebookTest() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
    }
}
