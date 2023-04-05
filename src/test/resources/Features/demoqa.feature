Feature: Checking Home page

  Background: User is on Home Page
    Given User launch the google chrome
    When User opens url 
    Then User is redirected to Home page
   # And User clicks on Element
@Skip
  Scenario Outline: Validating the Webtable Entries
    Given User is on the Element Page
    When User clicks on Webtable and click the add button
    Then It will show the Registration Form
    And User enters following details from "<JsonFile>" with "<Key>"
    And hit the enter button to submit
    Then The entry should be available in the table

    Examples: 
      |JsonFile         |Key       |
      |Registration.json|TC1       |
      |Registration.json|TC2       |
      
      #| firstname | lastname | emailid             | age | salary | Dept   |
      #| Devanshu  | Kumar    | devanshuk@gmail.com |  24 |   2700 | Dev    |
      #| John      | Steve    | johnsteve@yahoo.com |  32 |   2000 | Market |
 @smoke
 Scenario: Testing Login feature with invalid Credential
      Given User is on the Book Store Application
      When  User click on the Login Element 
      And Enters "Userlogin.json" with following "Credential"
      And Clicks on the Login Btn
      Then Invalid User message will print 
      