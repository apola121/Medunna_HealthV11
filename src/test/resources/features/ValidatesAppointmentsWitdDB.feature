Feature: test appointment data with DB


  @DBAppintments
  Scenario Outline:  test appointment data
    Given user sends the appointment query "<query>" to DB with column names "<columnName>"
    And user saves appointments  data in correspondent files
    Then user validates the appointment data
    Examples: test appointment data
      | query                   |columnName|
      | SELECT * FROM appointment |id      |