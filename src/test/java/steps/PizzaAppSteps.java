package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver = Driver.getDriver();
    PizzaAppPage pizzaAppPage=new PizzaAppPage();
    String costValue;
    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) throws InterruptedException {

        /*
        String strNum="1234";
        int myInt=Integer.parseInt(strNum);
         */
        Map<String, String> data = dataTable.asMap(String.class, String.class); //converting dataTable to Map (keys, values)
        for (Object object : data.values()) {
            System.out.println(object);
        }

        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropdown,data.get("Pizza")); // selecting value from Pizza dropdown
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping1Dropdown,data.get("Topping1"));// MUSHROOMS
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping2Dropdown,data.get("Topping2"));// EXTRA CHEESE
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.CONTROL+"A");
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity"));//"1"
        pizzaAppPage.nameBox.sendKeys(data.get("Name"));
        pizzaAppPage.emailBox.sendKeys(data.get("Email"));
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone"));
        costValue = pizzaAppPage.costBox.getAttribute("value"); //costValue = "6.75"
        Thread.sleep(3000);
        if(data.get("Payment").equals("Cash on Pickup")){
            pizzaAppPage.paymentRadioBtn.click();
        }else{
            pizzaAppPage.creditCardRadioButton.click();
        }
        pizzaAppPage.placeOrderBtn.click();
    }

    @Then("user validates that order is created with message {string} {string} {string}")
    public void userValidatesThatOrderIsCreatedWithMessageQuantityPizza(String success, String quantity, String pizza) {
        String expectedMessage = success+costValue+" "+pizza;
        String actualMessage = pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
