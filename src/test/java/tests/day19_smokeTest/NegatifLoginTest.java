package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    BrcPage brcPage=new BrcPage();

    @Test
    public void yanlisSifre(){
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        brcPage.ilkLoginButonu.click();
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        brcPage.ikinciLoginButonu.click();

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();

    }
}
