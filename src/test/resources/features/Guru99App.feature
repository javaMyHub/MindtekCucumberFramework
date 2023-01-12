@regression @ui

  Feature: Testing purchase functionalities

    Background: Signing in
      Given user navigates to "GuruApp" application
      Then user enters username "admin@mindtek.com" and password "admin" and clicks on login button

      @MTB-62
    Scenario: Validating price functionality
      And user clicks on Payment Gateway Project tab
      And user clicks on BUY NOW button for 3 toys
      And