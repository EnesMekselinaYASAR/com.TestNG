package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

        /*
        1.Facebook anasayfaya gidin
        2.Kullanıcı mail kutusuna rastgele isim yazdırın
        3.Kullanıcı şifre kutusuna rastgele bir password yazdırın
        4.Login butonuna basın
        5.Giriş yapılamadığını test edin
         */

    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        Driver.getDriver().get("https://facebook.com");
        Faker faker=new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        facebookPage.loginButonu.click();

        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();

    }
}
