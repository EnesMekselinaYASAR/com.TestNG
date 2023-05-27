package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri={{"firuze@nehaber.com", "54678"},
                                        {"murat@benbuisibilirim.com", "65874"},
                                        {"ilyas@selam.com", "85967"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEmail, String password) throws InterruptedException {
        brcPage=new BrcPage();
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        Thread.sleep(2000);
        brcPage.ilkLoginButonu.click();
        brcPage.emailTextBox.sendKeys(userEmail);
        brcPage.passwordTextBox.sendKeys(password);
        brcPage.ikinciLoginButonu.click();

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();

    }
}
