import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AliExpress {

    private WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aliexpress.com/");
    }

    @Test
    public void testProductSearches() {//ürün arama testi
        String searchKeyword = "Phone";
        WebElement searchBox = driver.findElement(By.id("search-words"));
        searchBox.sendKeys(searchKeyword);
        searchBox.click();//bu bir seçenek fakat bunu yaparsak sayfa üzerindeki arama butonunun çalışıp çalışmadığını test etmemiş oluruz.

        WebElement searchButton = driver.findElement(By.xpath("//input[@class=\"search--submit--2VTbd-T\"]"));
        searchButton.click();

        //sayfalarda çıkan pop-up ekran işlemleri
        String mainwindowHandle = driver.getWindowHandle(); //her pencere ve sekmenin winddows tarafından atanmış handle değerleri vardır. Şu an ana sayfamızın yani alipexpress penceresinin handle değerini alıyoruz.
        for(String windowHandle : driver.getWindowHandles()){ //başka bir handel değeri varsa ve main handel değerimize eşit değilse
            if(!windowHandle.equals(mainwindowHandle)){ //main handel değerine sahip pencereyi aç
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        

        driver.switchTo().window(mainwindowHandle); //ana sayfaya dönmek için











    }










}
