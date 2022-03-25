#@employee_login_scenario_outline
#Feature: employee_login
#
#  Scenario: user_verifies_signin_requirements

#      Given user is on Medunna Health website
#      And user clicks on the login dropdown
#      And user clicks on the sign in button
#      And verify the option to cancel login
#      And verify the remember me option
#      And verify the option Did you forget your password
#      And verify the option Register a new account
#      Then close the website
#
#  Scenario Outline: login_with_admin_credentials
#
#    Given user is on Medunna Health website
#    And user clicks on the login dropdown
#    And user clicks on the sign in button
#    And user sends username "<username>"
#    And user sends password "<password>"
#    And user clicks on the login button
#    Then verify the login is successful
#    Then user signs out
#
#    Examples: credentials
#
#      | username | password    |
#      | Admin80  | Welcome123! |
#
#
#
#
#
#
#
#