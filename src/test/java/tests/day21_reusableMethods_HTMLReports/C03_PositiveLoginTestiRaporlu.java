package tests.day21_reusableMethods_HTMLReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    BrcPage brcPage=new BrcPage();
    @Test
    public void pozitifLoginTest() {
        extentTest=extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris yapabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayafaya gidildi");
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("gecerli password yazildi");
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna basildi");

        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);
        extentTest.pass("Kullanici basarili sekilde giris yapti");
        Driver.closeDriver();
    }
}
