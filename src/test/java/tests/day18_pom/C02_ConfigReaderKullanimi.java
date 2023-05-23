package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {

    @Test
    public void test01() {
        /*
        1.Facebook anasayfaya gidin
        2.Kullanıcı mail kutusuna rastgele isim yazdırın
        3.Kullanıcı şifre kutusuna rastgele bir password yazdırın
        4.Login butonuna basın
        5.Giriş yapılamadığını test edin
        6.Sayfayı kapatin
        */

        FacebookPage facebookPage=new FacebookPage();

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        facebookPage.loginButonu.click();
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();





    }
}
