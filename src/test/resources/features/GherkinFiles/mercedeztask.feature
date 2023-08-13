@mercedesAutomation
Feature: A Class Model price Validation

  @validate_a_class_model_price_in_Range
  Scenario: Validate A Class models price are between £15,000 and £60,000"
    Given Open Mercedes-benz United Kingdom market
    When Under Our Models - Select Model: "Hatchbacks"
    And Mouse over the "A-Class" model available and proceed to "Build your car"
    When Filter by Fuel type "Diesel"
    Then Should see only "Diesel" fuel type items
    Then Verify that the catalog should be sorted according the default sorting method
    When Save the screenshot of the resultant screen
    And Save Highest and lowest price in the text file
    Then Verify that the text file should exist and should contain price values
    Then Verify that the price range should be between "£15,000" and "£60,000"





