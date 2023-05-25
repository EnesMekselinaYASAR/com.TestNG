package tests.day21_reusableMethods_HTMLReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        //Click here butonuna basın
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());

        //açılan yeni tab'in title'ının "New Window" olduğunu test edin.
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();

    }
}
