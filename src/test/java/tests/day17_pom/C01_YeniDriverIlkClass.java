package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        /*
        Bugüne kadar TestBase class'ına extends ederek kullandığımız driver yerine bundan sonra
        Driver class'ından kullanacağımız getDriver static methodunu kullanacağız.

              Driver.getDriver()...  in
              driver            ...  out
         */
        Driver.closeDriver();
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();
    }
}
