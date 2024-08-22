package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class amazon01 {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Tarayıcıyı pencere boyutunu maximize ediyoruz.

        //Amazon web sayfasına giriş.

        driver.get("https://www.amazon.com");

        //Arama kutusuna "Laptop" yazıp enter'a basarak arama yapıyoruz.'
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");

        //Arama butonunu bulup tıklıyoruz.
        driver.findElement(By.id("nav-search-submit-button")).click();

        //Arama sonucunda bulunan ilk ürünün başlığını ekrana yazdırıyoruz.
       WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
       String Uruntitle = ilkUrun.getText();
       System.out.println("Arama sonucunda bulunan ilk ürün: " + Uruntitle);

       //Arama sonucunda bulunan ilk ürünün fiyatını ekrana yazdırıyoruz.
        WebElement ilkUrunFiyat= driver.findElement(By.className("a-price-whole"));
        String UrunFiyati = ilkUrunFiyat.getText();
        System.out.println("Arama sonucunda bulunan ilk ürün fiyatı: " + UrunFiyati);

        ilkUrun.click(); //Arama sonucunda bulunan ilk ürünü tık
        //Tıklanan ürünü sepete ekleme.
        //Açılan ürün sayfasında sepete ekle butonuna tıklayın.

       WebElement Urun = driver.findElement(By.id("add-to-cart-button"));
       Urun.click();

       Thread.sleep(3000);//üç saniye bekletiyoruz. İnterneti yavaş kullanıcılar olabileceği için önemli bir adım.


       //ürünün adının sepete doğru şekilde eklenip eklenmediğini kontrol edin.
        WebElement card = driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a"));
        card.click(); //Kullanıcı onaylıyor.

        Thread.sleep(3000);



        //Ürün başlığı yazılmış mı kontrol edelim.
        WebElement urunBaslik = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div/div/h1"));
       String expectedTitle = "Shopping Cart";
       Assert.assertTrue(urunBaslik.getText().contains(expectedTitle), "Expected title is not found");

        Thread.sleep(3000);

       








    }
}
