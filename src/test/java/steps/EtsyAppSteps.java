package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchResultsPage;
import pages.EtsyTitlePages;
import utilities.Driver;
import java.util.List;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchResultsPage etsyAppSearchResultsPage = new EtsyAppSearchResultsPage();
    EtsyTitlePages etsyTitlePages = new EtsyTitlePages();

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyAppHomePage.searchBox.sendKeys(item + Keys.ENTER);
    }

    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_contains_keyword(String keyword) {
        List<WebElement> myItemsList = etsyAppSearchResultsPage.listOfItemsTitles;

        for (WebElement element : myItemsList) {
            if (element.getText().contains(keyword)) {
                System.out.println(element.getText());
                Assert.assertTrue("Item doesn't contain " + keyword + " keyword " + element.getText(),
                        element.getText().toLowerCase().contains(keyword));
            }
        }
    }

    @And("user applies price filter {string} dollars")
    public void userAppliesPriceFilterOverDollars(String filterRange) {
        etsyAppSearchResultsPage.filterButton.click();
        switch (filterRange) {
            case "over 1500":
                etsyAppSearchResultsPage.filterRadioButtonOver1500.click();
                break;
            case "under 250":
                etsyAppSearchResultsPage.filterRadioButtonUnder250.click();
                break;
            case "250 to 750":
                etsyAppSearchResultsPage.filterRadioButton250To750.click();
                break;
            case "750 to 1500":
                etsyAppSearchResultsPage.filterRadioButton750To1500.click();
                break;
        }
        etsyAppSearchResultsPage.applyButton.click();
    }


    @Then("user validates that item prices are {string} dollars")
    public void userValidatesThatItemPricesAreOverDollars(String filterRange) throws InterruptedException {

        switch (filterRange) {
            case "over 1500": {
                Thread.sleep(3000);
                List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

                for (WebElement element : prices) {
                    System.out.println(element.getText());
                    //String = "2,299.00" --> double = 2299.00
                    String priceStr = element.getText().replace(",", ""); //"1920.00"
                    double actualPriceDbl = Double.parseDouble(priceStr);// 1929.00
                    System.out.println(actualPriceDbl);
                    String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                    double expectedpriceDbl = Double.parseDouble(expectedPrice);

                    Assert.assertTrue(actualPriceDbl >= expectedpriceDbl); // 1920.00 >= 1500.00

                }

                break;
            }
            case "under 250": {
                Thread.sleep(3000);
                List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

                for (WebElement element : prices) {
                    System.out.println(element.getText());
                    //String = "2,299.00" --> double = 2299.00
                    String priceStr = element.getText().replace(",", ""); //"1920.00"
                    double actualPriceDbl = Double.parseDouble(priceStr);// 1929.00
                    System.out.println(actualPriceDbl);
                    String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                    double expectedpriceDbl = Double.parseDouble(expectedPrice);

                    Assert.assertTrue(actualPriceDbl < expectedpriceDbl); // 1920.00 <= 250

                }
                break;
            }
            case "250 to 750": {
                Thread.sleep(3000);
                List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

                for (WebElement element : prices) {
                    System.out.println(element.getText());
                    //String = "2,299.00" --> double = 2299.00
                    String priceStr = element.getText().replace(",", ""); //"1920.00"
                    double actualPriceDbl = Double.parseDouble(priceStr);// 1929.00
                    System.out.println(actualPriceDbl);
                    String expectedPrice1 = filterRange.substring(0, filterRange.indexOf(" ") + 1);//250
                    double expectedpriceDbl1 = Double.parseDouble(expectedPrice1);
                    String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ") + 1);//250
                    double expectedpriceDbl2 = Double.parseDouble(expectedPrice2);//750

                    Assert.assertTrue(actualPriceDbl >= expectedpriceDbl1 && actualPriceDbl <= expectedpriceDbl2); // 1920.00 <= 250

                }

                break;
            }
            case "750 to 1500": {
                Thread.sleep(3000);
                List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

                for (WebElement element : prices) {
                    System.out.println(element.getText());
                    //String = "2,299.00" --> double = 2299.00
                    String priceStr = element.getText().replace(",", ""); //"1920.00"
                    double actualPriceDbl = Double.parseDouble(priceStr);// 1929.00
                    System.out.println(actualPriceDbl);
                    String expectedPrice1 = filterRange.substring(0, filterRange.indexOf(" ") + 1);//750
                    double expectedpriceDbl1 = Double.parseDouble(expectedPrice1);
                    String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ") + 1);//1500
                    double expectedpriceDbl2 = Double.parseDouble(expectedPrice2);//750

                    Assert.assertTrue(actualPriceDbl >= expectedpriceDbl1 && actualPriceDbl <= expectedpriceDbl2); // 1920.00 <= 250

                }

                break;
            }
        }
    }
    @When("user clicks on {string} section")
    public void user_clicks_on_section(String section) {
        switch (section) {
            case "Jewelry & Accessories":
                etsyAppHomePage.jewelryAndAccessories.click();
                break;
            case "Clothing & Shoes":
                etsyAppHomePage.clothingAndShoes.click();
                break;
            case "Home & Living":
                etsyAppHomePage.homeAndLiving.click();
                break;
            case "Wedding & Party":
                etsyAppHomePage.weddingAndParty.click();
                break;
            case "Toys & Entertainment":
                etsyAppHomePage.toysAndEnt.click();
                break;
            case "Art & Collectibles":
                etsyAppHomePage.artAndColl.click();
                break;
            case "Craft Supplies":
                etsyAppHomePage.craftAndSupp.click();
                break;
            case "Gifts & Gift Cards":
                etsyAppHomePage.giftsAndCards.click();
                break;
        }

    }

    @Then("user validates the title is {string} and the header is {string}")
    public void user_validates_the_title_is_and_the_header_is(String title, String header) {
        String actualHeader = "";
        String actualTitle = "";
        switch (header) {
            case "Jewelry & Accessories":
                actualHeader = etsyTitlePages.jaHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Clothing & Shoes":
                actualHeader = etsyTitlePages.csHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Home & Living":
                actualHeader = etsyTitlePages.hlHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Wedding & Party":
                actualHeader = etsyTitlePages.wpHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Toys & Entertainment":
                actualHeader = etsyTitlePages.teHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Art & Collectibles":
                actualHeader = etsyTitlePages.acHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "Craft Supplies & Tools":
                actualHeader = etsyTitlePages.cstHeader.getText();
                actualTitle = driver.getTitle();
                break;
            case "The Etsy Gift Guide":
                actualHeader = etsyTitlePages.ggHeader.getText();
                actualTitle = driver.getTitle();
                break;
        }
        Assert.assertEquals(title,actualTitle);
        Assert.assertEquals(header,actualHeader);

    }
}
