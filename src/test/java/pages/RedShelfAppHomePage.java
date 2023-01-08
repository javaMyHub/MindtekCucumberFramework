package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RedShelfAppHomePage {

    public RedShelfAppHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search-catalog-navbar")
    public WebElement searchBox;



    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/main[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement errorMessage;

    @FindBy(xpath = "//h1[@class='mdc-typography--headline4']")
    public WebElement textBoxMessage;







}
