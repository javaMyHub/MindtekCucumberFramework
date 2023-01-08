package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedShelfAppHomePage;
import utilities.Driver;

public class RedShelfAppSteps {

    WebDriver driver = Driver.getDriver();
    RedShelfAppHomePage redShelfAppHomePage = new RedShelfAppHomePage();


    @When("user searches {string} book")
    public void userSearchesBook(String text) {
        redShelfAppHomePage.searchBox.sendKeys(text);
        redShelfAppHomePage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("user validates {string} error message.")
    public void userValidatesErrorMessage(String expectedMessage) {

        String actualMessage = redShelfAppHomePage.errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("user searches for book name that has more than {int} characters")
    public void user_searches_for_book_name_that_has_more_than_characters(Integer num) throws InterruptedException {
        String str = "a";
        String repeated = str.repeat(num + 1);

        String str1 = "b";
        String repeated1 = str1.repeat(2);

        redShelfAppHomePage.searchBox.sendKeys(repeated + repeated1 + Keys.ENTER);

        Thread.sleep(3000);
    }

    @Then("user validates that search box doesn’t accept more than {int} characters.")
    public void user_validates_that_search_box_doesn_t_accept_more_than_characters(Integer num) {

        String text = redShelfAppHomePage.textBoxMessage.getText();
     //   text.split((" "))[3];
        //  string.split("   ")[1]

        System.out.println(redShelfAppHomePage.textBoxMessage.getText());
        int wordNum = text.length();

        String expectedNum=num.toString();
        String actualNum=wordNum+"";

        Assert.assertEquals(expectedNum,actualNum);


    }
}
