package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class UdemyPage {

    public UdemyPage() { // UdemyPage class'ı için constructor'ı yazdık.yapıcı metot.
        PageFactory.initElements(Driver.getDriver(), this);
        //yani bu yöntemle web driver nesnesini başarıyla sayfada başlatmış oluruz. Sayfadaki ögelerle etkileşimde bulunmayı sağlar.
        //buradan alınan web elementleri test tarafında çağırabileceğiz.

    }
    @FindBy(name = "q")
    public WebElement searchBox; // arama kutusu elementi.


}
