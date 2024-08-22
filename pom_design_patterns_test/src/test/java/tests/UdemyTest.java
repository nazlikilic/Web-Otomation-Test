package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.UdemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class UdemyTest {

 UdemyPage udemy = new UdemyPage(); // UdemyPage s
    @Test
    public void testUdemy() {

        Driver.getDriver().get(ConfigReader.getProperty("urlUdemy")); // web sayfasına giriş yapıyoruz

        //kursun arama kısmına git ve kursun adını gir.
       udemy.searchBox.sendKeys(ConfigReader.getProperty("textAppium"),Keys.ENTER);



    }
}
