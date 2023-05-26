package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String expectedKelime="Nutella";
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedKelime));
        Driver.closeDriver();
    }
}
