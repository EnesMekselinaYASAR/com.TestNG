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

    @Test(dataProvider = "AranacakKelimeler")
    // arayacagimiz kelimeleri bir liste gibi tutup
    // bana yollayacak bir veri saglayicisi olusturacagiz
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);
        String expectedKelime=arananKelime;
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedKelime));

        Driver.closeDriver();


    }
}
