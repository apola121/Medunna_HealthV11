Feature: Validating Appointments with API

  @ValidateApp
  Scenario Outline:  api get request for appointments
    Given user sets the necessary path params for appointments
    And user sends the get request for appointment data
    And user deserializes appointment data to Java
    And user saves the users appointment data to correspondent files
    Then user validates api appointment with "<id>" , "<startDate>", "<endDate>", "<status>"

    Examples:
      | id    | startDate            | endDate              | status     |
      | 12175 | 2022-03-25T00:00:00Z | 2022-03-25T01:00:00Z | UNAPPROVED |
      | 12175 | 2022-03-23T00:00:00Z | 2022-03-23T01:00:00Z | PENDING    |
      | 12175 | 2022-04-01T00:00:00Z | 2022-04-01T01:00:00Z | PENDING    |
      | 12175 | 2022-03-17T00:00:00Z | 2022-03-17T01:00:00Z | PENDING    |

#      |12175|2022-03-15T00:00:00Z|2022-03-15T01:00:00Z| UNAPPROVED |
#      |12175|2022-03-21T00:00:00Z|2022-03-21T01:00:00Z| UNAPPROVED |
#      |12175|2022-03-16T00:00:00Z|2022-03-16T01:00:00Z| UNAPPROVED |
#      | 3362 | 2022-01-01T00:00:00Z | 2022-01-01T01:00:00Z | UNAPPROVED |
#      | 4856 | 2022-01-04T00:00:00Z | 2022-01-04T01:00:00Z | UNAPPROVED |