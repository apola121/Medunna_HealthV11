Feature: E2E_DB

 // @SmokeTestDB @DBPhysician
  Scenario Outline:  physician data with DB
    Given user sends the physician query "<query>" to DB
    And user saves physician  data in correspondent files
    Then user validates the physician data with UI data
    Examples:
      | query                     | columnName1 | columnName2 |
      | SELECT * FROM physician | first_name  | last_name   |

#with column names "<columnName1>" and "<columnName2>"