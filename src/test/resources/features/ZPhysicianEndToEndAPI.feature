Feature: E2E_API

  @SmokeTestAPI @PhysicianAPI

  Scenario: verification of physician with API
    Given user sets the necessary path params for physician data
    And user sends the get request for physician data
    And user deserializes physician data to Java
    And user saves the physician data to correspondent files
    Then user validates physician with UI Physician data