Feature: Physician test

 // @SmokeTestAPI @SmokeTestDB @PhysicianUI

  Scenario Outline: test physician
    Given user is on Medunna Health website
    And user clicks on the login dropdown
    And user clicks on the sign in button
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the login button
    And user clicks on Administration DropDown
    And user clicks user management
    And user clicks create a new user button
    And user enters login "<login>",First Name "<firstName>",Last Name "<lastName>",Email "<email>", SSN "<ssn>"
    And user choose items and titles and clicks physician
    And user hit create a new physician button and search by ssn
    And user adds phone number "<phoneNumber>", exam fee "<examFee>"and hit save button

    Examples: credentials
      | username | password    | login   | firstName | lastName | ssn         | phoneNumber  | examFee |
      | Admin80  | Welcome123! | hello33 | Jonny     | Sweet    | 329-98-7825 | 677-980-9998 | 999     |
#      | Admin80  | Welcome123! | hello33 | Jonny     | Sweet    | 329-98-7825 |677-980-9998|999    |