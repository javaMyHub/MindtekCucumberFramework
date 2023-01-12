package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Guru99HomePage {
    public Guru99HomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


}
