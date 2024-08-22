package utilities; //selenium web driver ı yönetmek ve tarayıcıları yapılandırmak için kullanılan sınıf.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class Driver {
    private static WebDriver driver; //erişim belirtecini private yaparak driver sınıfının dışından bir erişimi engelledik ve driver sınıfından bir nesne tanımladık.
    private Driver(){
    //driver sınıfının dışında bir nesne oluşturulmasını engelledik.
    }
    public static WebDriver getDriver(){ //yönetilen web driver nesnesini döndüren metodu tanımladık.
       String Browser = ConfigReader.getProperty("browser");

      if(driver==null){
          switch (Browser){
              case "edge":
                  WebDriverManager.edgedriver().setup();
                  driver = new EdgeDriver();
                  break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver = new FirefoxDriver();
                  break;
                  case "safari":
                      WebDriverManager.safaridriver().setup();
                      driver = new SafariDriver();
                      break;
              default:
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();

                  driver.manage().window().maximize();
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//thread.sleep ile aynı bekleme süresi ekledik.
          }
      }

     return driver;

    }

    public static void  closeDriver(){
        if(driver!=null){
            driver.close(); //web driver'ı kapatır ve sıfırlar'
            driver = null;
        }
    }


    public static void  quitDriver(){
        if(driver!=null){
            driver.quit(); //web driver'ı kapatır ve tüm pencereleri sıfırlar'
            driver = null;
        }
    }











}
