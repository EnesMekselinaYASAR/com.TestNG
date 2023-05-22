package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.security.Key;
import java.util.List;

public class C07_SoftAssert extends TestBase {

    /*
1."http://zero.webappsecurity.com/" adresine gidin
2.Sign in butonuna tıklayın.
3.Login kutusuna "username" yazın.
4.Password kutusuna "password" yazın.
5.Sign in butonuna basın
6.Online banking menüsü içinde Pay Bills sayfasına gidin.
7."Purchase Foreing Currency" tuşuna basın.
8."Currency" drop down menüsünden Eurozone'u seçin
9.soft assert kullanarak "Eurozone (Euro)" seçildiğini test edin.
10.soft assert kullanarak DropDown listesinin şu seçenekleri olduğunu test edin
  */

    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();
        WebElement loginKutusu=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");
        WebElement passKutusu=driver.findElement(By.xpath("//input[@type='password']"));
        passKutusu.sendKeys("password");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        WebElement ddo=driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");

        SoftAssert softAssert=new SoftAssert();
        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option dogru degil");

        List<WebElement> optionList=select.getOptions();


    }
}
