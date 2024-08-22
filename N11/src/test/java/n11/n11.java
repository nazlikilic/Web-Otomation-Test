package n11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class n11 {

    private WebDriver driver;
  @BeforeEach
  public void setup() {

      driver = new ChromeDriver();
      driver.manage().window().maximize();

  }
@Test //junit e bunun bir test olduğunu tanıtmamıza yarayan anotasyon.
  public void testN11Scenario() throws InterruptedException {
      driver.get("https://www.n11.com/");


    //Arama kutusuna ürün adı girelim.
    WebElement searchButton = driver.findElement(By.id("searchData"));//burada aradığımız bir web element
    searchButton.sendKeys("Samsung Galaxy S21 Ultra" , Keys.ENTER); //searchButton.click(); Keys.Enter ile aynı görevi yapar.

    //Kaç adet sonuç çıktığını kontrol ediyoruz.
    String aramaSonucu = driver.findElement(By.className("resultText")).getText();//burada aradığımız bir web element değil bir string.
    String actualAramaSonucu = "Samsung Galaxy S21 Ultra için 2,851 sonuç bulundu.";
    assertEquals(actualAramaSonucu, aramaSonucu); //arama sonucu eşleştiğini kontrol ediyoruz.

    Thread.sleep(2000);;
   driver.navigate().back(); // bir önceki sayfaya geri dönmek için.

    Thread.sleep(2000);;
    driver.navigate().forward(); // bir sonraki sayfaya gitmek için.

}
    @Test
    @Disabled("Bu test geçici olarak devre dışı bırakıldı.")//devre dışı bırakmak istediğimiz test senaryosunun başına Disabled anotasyonu eklemeliyiz.
    public void testN11Scenario2() throws InterruptedException {
        driver.get("https://www.n11.com/");
        //Başlığın doğru olduğunun kontrol testi:

        String expectedPageTitle = "N11 - Hayat Sana Gelir"; //olmasını beklediğimiz title.
        String actualPageTitle = driver.getTitle(); //sayfadaki title ne ise onu alan metot.
        assertEquals(expectedPageTitle, actualPageTitle, "Başlık eşleşmedi");



    }
@AfterEach
//her test metodunun sonunda driver.quit() metodu çağrılmasını @AfterEach anotasyonu ile sağlıyoruz.
    public void teardown() { //oturum sonlandırma metodu teardown.
      driver.quit(); //driverdan çık. sayfa kapanır yeni sekme açmayı engellemiş oluruz.
    }


}



