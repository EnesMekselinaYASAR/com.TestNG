package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {
    /*
    1-amazon anasayfaya gidin
    2-title in Amazon içerdigini test edin
    3-arama kutusnun erişilebilir oldugunu test edin
    4-arama kutusuna Nutella yazıp aratın
    5-arama yapıldıgını test edin
    6-arama sonucunun Nutella içerdigini test edin

     */

    /*
    ***Hard  Assert***

        JUnit 'te öğrendiğimiz assertion ile aynıdır. TestNG'de soft assertion da olduğundan
        ayrıştırmak için bu isimle kullanılmıştır.

         JUnit'ten bildiğimiz üzere kullanabileceğimiz 3 çeşit hard assertion türü vardır.
            ı.Assert.assertEquals()
            ıı.Assert.assertTrue()
            ııı.Assert.assertFalse()

        Hard assertion her hangi bir assertion FAILED olursa, test method çalışmasını durdurur(ilk assertionda durdurur)
        ve kalan kodları yürütmez.(stop execution)
     */

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        Assert.assertTrue(sonucYaziElementi.getText().contains("Kutella"));
    }
}
