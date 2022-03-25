@UI
Feature: registration data test

  @UIRegistration
  Scenario Outline:  test registrations

    Given user provides ssn "<SSN>"
    And user sends firstname and lastname "<firstname>" and "<lastname>"
    And user provides username "<username>"
    Then user provides email as "<email>"
    And user provides password "<password>"
    And user registers and validates data generation
    Then user sets the data in correspondent files

    Examples: test data
      |SSN|firstname|lastname|username|email|password|
      | 381-59-2857  |Elanur         |    Selcuk    |   elanurselcuk     |  elanur@gmail.com   |    Asdfg1234.    |