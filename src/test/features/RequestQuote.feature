Feature: Request quote from web

  Background:
    Given User navigates to the web

    Scenario: Request quote successfully
      When Enters the work email
      And Clicks on the first step next button
      And Enters the first name
      And Enters the last name
      And Enters the phone number
      And Clicks on the second step next button
      And Enters company name
      And Enters number of employees
      And Selects country
      And Selects primary interests
      And Clicks on submit button
      Then Verifies the quote submission