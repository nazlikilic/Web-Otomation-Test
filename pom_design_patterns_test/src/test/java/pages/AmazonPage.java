package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() { // AmazonPage class'ı için constructor'ı yazdık.

        PageFactory.initElements(Driver.getDriver(), this);

       }
       @FindBy(id = "twotabsearchtextbox")
         public WebElement searchBox;






}
