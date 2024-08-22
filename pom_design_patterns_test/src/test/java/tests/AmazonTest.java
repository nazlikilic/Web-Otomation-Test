package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;


import java.util.List;

import static utilities.Driver.quitDriver;

public class AmazonTest {
    public WebDriver driver;

    AmazonPage amazon = new AmazonPage();

    @Test
    public void searchProduct() {
        WebDriver driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("urlAmazon"));
        amazon.searchBox.sendKeys(ConfigReader.getProperty("textSearch"), Keys.ENTER);

        String pageTtitle = Driver.getDriver().getTitle();
        String expectedTitle = "Amazon.com : samsung note 21";
        Assert.assertEquals(pageTtitle, expectedTitle, "Expected title did not match actual title");


        //sayfadaki ürün başlıklarını sıralayan bir liste yapalım
        List<WebElement>productTitles = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
        //ürün titellarını productTitles adlı list web element nesnesine atadık.

         for (WebElement productTitle : productTitles){ //productTitle listesindeki her bir elemanın başlıklarını string titel değişkenine atadık ve döndürdük.
             String title = productTitle.getText();
             System.out.println("Product Title: " + title); //ürün başlıklarını ekrana yazdıralım.

         }

         int actualTitleCount = productTitles.size(); // productTitles listesindeki ürünlerin başlık sayısını aldık.
        System.out.println("Actual Title Count: " + actualTitleCount); //actualTitleCount

        int  expectedTitleCount = 10; // beklenen ürün sayısı

        Assert.assertEquals(actualTitleCount, expectedTitleCount, "Expected title count did not match actual title count"); // beklenen ve gerçek ürün sayısını karşılaştırıyoruz.




        JavascriptExecutor js = (JavascriptExecutor) driver; //web driver aracılığıyla sayfadaki java script kodlarını çalıştırmamızı sağlar.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)"); // sayfayı en alttan en üste indirmek için. Window.scrollTo belirtilen eksenlerde değiştirmek için kullanılır
        //scrollHeight, sayfanın yüksekliğini belirtir. scrollLeft sayfanın solunu belirtirir.
        //javascript nesnesi driver'ın executeScript metodunu kullanarak sayfaya bir scroll işlemi yapıyor
        // /2 ise sayfanın ortasında scroll ediyor.



      quitDriver(); //tarayıcıyı kapattık.




    }



}
