@regression @ui @MTB-60

  Feature: User validates that search box is working correctly

    @MTB-61
    Scenario: User validates error message when user searches invalid search
      Given user navigates to "RedShelfApp" application

      When user searches "abcdefgh" book

      Then user validates "Check your spelling or try a different search." error message.

    @MTB-62
    Scenario:  User validates that search box has a higher boundary
      Given user navigates to "RedShelfApp" application

      When user searches for book name that has more than 255 characters

      Then user validates that search box doesn’t accept more than 255 characters.
