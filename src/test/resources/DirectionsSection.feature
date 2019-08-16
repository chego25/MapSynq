Feature: Directions Section

  The Directions section of MapSynq web application is responsible to provide a real-time direction
  to the user who is commuting or about to commute from a source to a destination. As the result comes
  in the embedded Google Maps, only form related functionalities will be tested here in this feature.

  Scenario: Directions Checks
    Given a user tries to open MapSynq application
    When he clicks on the Directions Section button
    Then the Traffic Check should have the text \"Traffic aware\"
    And the Traffic Check should have the status \"checked\"
    And the Toll Check should have the text \"Toll aware\"
    And the Toll Check should have the status \"unchecked\"
    And the Fastest Check should have the text \"Fastest\"
    And the Fastest Check should have the status \"unchecked\"
    And the Shortest Check should have the text \"Shortest\"
    And the Shortest Check should have the status \"unchecked\"