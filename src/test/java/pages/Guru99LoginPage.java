package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99LoginPage {
    public Guru99LoginPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }




}
