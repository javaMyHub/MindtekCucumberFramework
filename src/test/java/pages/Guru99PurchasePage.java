package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99PurchasePage {
    public Guru99PurchasePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }




}
