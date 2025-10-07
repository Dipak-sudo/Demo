Feature: Login feature


Background:
 Given user navigate to the login page
 
 
  #@login
  #Scenario Outline: Login with valid credentials
   
   # When user enters valid "<email>" and password "<password>"
    #And clicks on login button
    #Then the user should successfully login

    #Examples: 
     # | email                  | password  |
     #| mogoge7150@flektel.com | Test@1234 |  
      
#@login                                   #with exel file
  # Scenario: Login with data from Excel
  #  When user logs in with data from Excel "src/test/resources/TestData.xlsx" and sheet "LoginData"
   # Then the user should successfully login
   
    @login
  Scenario: Login with DataTable
    When user logs in with following details
      | email    | test123@gmail.com |
      | password | Test@123          |
    Then the user should successfully login

      


  Scenario: Error message should be diaplayed on loging with invalid credentials
    
    When the user enters Invalid user name "test" and invalid password "test"
    And clicks on login button
    Then the error message should be displayed


  Scenario: User should be able to naviagte to forgot password
    
    When the user clicks on the forgot password
    Then the user should naviagte to forgot password page
 