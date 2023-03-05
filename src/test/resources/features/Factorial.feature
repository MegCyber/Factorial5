Feature: Factorial Calculation
  As a user of the Factorial Calculator
  I want to calculate the factorial of a number
  So that I can verify the calculation is correct

  Scenario: Calculate the factorial of 5
    Given I am on the Factorial calculator page
    When I enter "5" as the number
    And I click the calculate button
    Then the result should be "120"
