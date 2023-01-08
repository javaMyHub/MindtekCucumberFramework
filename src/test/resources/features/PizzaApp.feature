@regression  @UI
Feature: Pizza application place order functionality

  @RTB-5
  Scenario Outline:
    Given user navigates to "PizzaApp" application
    When user creates pizza order with data
      | Pizza    | <Pizza>    |
      | Topping1 | <Topping1> |
      | Topping2 | <Topping2> |
      | Quantity | <Quantity> |
      | Name     | <Name>     |
      | Email    | <Email>    |
      | Phone    | <Phone>    |
      | Payment  | <Payment>  |

    Then user validates that order is created with message "Thank you for your order! TOTAL: " "<Quantity>" "<Pizza>"


    Examples:
      | Pizza                        | Topping1  | Topping2           | Quantity | Name         | Email           | Phone     | Payment        |
      | Small 6 Slices - no toppings | Mushrooms | Extra cheese       | 1        | Alex Pushkin | alexp@gmail.com | 123456789 | Cash on Pickup |
      | Large 10 Slices - 2 toppings | Olives    | Caramelized onions | 2        | James Bond   | jbond@gmail.com | 987654321 | Credit Card    |
      | Small 6 Slices - no toppings | Salami    | Extra cheese       | 4        | Jacky Chen   | chenj@gmail.com | 125556789 | Cash on Pickup |





