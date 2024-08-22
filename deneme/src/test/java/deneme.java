//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class deneme {

    public static void main(String[] args) {
        // WebDriverManager ile ChromeDriver'ı otomatik olarak yönetin

        WebDriver driver = new ChromeDriver();
        // Tarayıcıyı kullanarak işlemlerinizi yapın
        driver.get("https://www.google.com");
        // Tarayıcıyı kapatın

    }
}
