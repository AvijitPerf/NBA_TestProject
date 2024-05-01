#Author: avijit.job92@gmail.com
Feature: Derived Product2 feature

  Scenario: Find all the hyperlinks of the Footer links into a CSV file
    Given I am on the DP2 Home Page
    When I scroll down to the footer of the page
    Then I can see the following categories
      | TEAM          |
      | TICKETS       |
      | SHOP          |
      | COMMUNITY     |
      | UNITED CENTER |
      | NEWS          |
     And I can write all hyperlinks in "hyperLinks.csv" file
     And I validate if any duplicate hyperlinks present at footer
