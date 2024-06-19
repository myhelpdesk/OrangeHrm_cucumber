Feature: New Employee Registration

  @tag1
  Scenario: Check New Employee Registration with valid inputs
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I enter user name as "Admin"
    And I enter password as "Qedge123!@#"
    And I click login
    Then I should see admin module or page
    When I go to add employee page
    And I enter firstname as "Richards"
    And I enter lastname as "R"
    And I click save
    Then I should see registered employee in employee list
    When I click logout
    Then I should see login page
    When I close browser