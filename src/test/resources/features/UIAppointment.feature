Feature: appointments test


  @Regression
    @Appointment
  Scenario Outline: test appointments
    Given user clicks on make an appointment
    And user provides the appointment name "<firstname>"
    And user provides the appointment lastname "<lastname>"
    And user provides ssn and email "<SSN>" and "<email>"
    When user provides the phone number "<phoneNumber>"
    And user provides the date "<date>"
    Then user requests appointment and verifies the success message
    Examples: test data
      | firstname | lastname | SSN         | email           | phoneNumber  | date       |
      | Cetin     | Isilak   | 203-38-2837 | cetin@gmail.com | 253-283-2837 | 06-07-2022 |