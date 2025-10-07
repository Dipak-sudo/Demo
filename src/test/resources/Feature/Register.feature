Feature: Registration functionality

  @reg
  Scenario Outline: To verify that user can create account with mandatory fields only
    Given user naviagtes to registration page
    And enters the mandatory fields "<firstname>" "<lastname>" "<email>" "<phonenumber>" "<password>" "<confirmpassword>"
    And selects privacy policy
    And clicks on continue button
    Then the account should get created successfully

    Examples: 
      | firstname | lastname | email       | phonenumber | password  | confirmpassword |
      | test1     | test2    | randomemail |  8989898989 | Test@1234 | Test@1234       |
      | test1     | test2    | randomemail |  8989898989 | Test@1234 | Test@1234       |
