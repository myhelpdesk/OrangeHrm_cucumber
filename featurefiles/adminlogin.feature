@tag
Feature: Admin Login
  I want to use this template to check Admin Login

  @tag1
  Scenario: Chek admin login with valid inputs
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I enter user name as "Admin"
    And I enter password as "Qedge123!@#"
    And I click login
    Then I should see admin module or page
    When I click logout
    Then I should see login page
    When I close browser

  @tag2
  Scenario Outline: Chek admin login with invalid inputs
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see login page
    When I enter user name as "<username>"
    And I enter password as "<password>"
    And I click login
    Then I should see error message
    When I close browser

    Examples: 
      | username | password |
      | Admin    | xyz      |
      | xyz      | Qedge    |
      | abc      | xyz      |
      |          | Qedge    |
      | Admin    |          |
      |          |          |