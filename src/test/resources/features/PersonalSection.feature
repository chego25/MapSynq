Feature: Personal Section

  The Personal section of MapSynq web application contains nothing but a link to the App Page and a
  button to the Register Page. This feature is responsible to test the navigation to those pages.

  @severity=normal
  Scenario: App Page Switch
    Given a user tries to open MapSynq application
    And he clicks on the Personal Section button
    When he clicks on the advertised App Page link
    Then the App Page should have the title "mapSYNQ Mobile"

  @severity=normal
  Scenario: Register Page Switch
    Given a user tries to open MapSynq application
    And he clicks on the Personal Section button
    When he clicks on the Register Page Button
    Then the App Page should have the title "mapSYNQ user profile"