package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99PaymentGatewayPage {
    public Guru99PaymentGatewayPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy()

}
