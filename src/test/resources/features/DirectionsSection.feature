Feature: Directions Section

  The Directions section of MapSynq web application is responsible to provide a real-time direction
  to the user who is commuting or about to commute from a source to a destination. As the result comes
  in the embedded Google Maps, only form related functionalities will be tested here in this feature.

  @severity=minor
  Scenario: Directions Checks
    Given a user tries to open MapSynq application
    When he clicks on the Directions Section button
    Then the Source Field should have the text "Current Location"
    And the Destination Field should have the text ""
    And the Traffic Check should have the text "Traffic aware"
    And the Traffic Check should have the status "checked"
    And the Toll Check should have the text "Toll aware"
    And the Toll Check should have the status "unchecked"
    And the Fastest Check should have the text "Fastest"
    And the Fastest Check should have the status "unchecked"
    And the Shortest Check should have the text "Shortest"
    And the Shortest Check should have the status "unchecked"

  @severity=normal
  Scenario: Directions Swap
    Given a user tries to open MapSynq application
    And he clicks on the Directions Section button
    And he types "Resorts World Sentosa" in the Source Field
    And he types "Merlion" in the Destination Field
    When he clicks on the Swap Value button
    Then the Source Field should have the text "Merlion"
    And the Destination Field should have the text "Resorts World Sentosa"

  @severity=normal
  Scenario: Directions Clear
    Given a user tries to open MapSynq application
    And he clicks on the Directions Section button
    And he types "Resorts World Sentosa" in the Source Field
    And he types "Merlion" in the Destination Field
    And he selects the "Traffic Aware" option
    And he selects the "Toll Aware" option
    And he selects the "Fastest" option
    And he selects the "Shortest" option
    When he clicks on the Clear Route button
    Then the Source Field should have the text ""
    And the Destination Field should have the text ""
    And the Traffic Check should have the status "unchecked"
    And the Toll Check should have the status "unchecked"
    And the Fastest Check should have the status "unchecked"
    And the Shortest Check should have the status "unchecked"

  @severity=critical
  Scenario: Directions Search
    Given a user tries to open MapSynq application
    And he clicks on the Directions Section button
    And he types "Resorts World Sentosa" in the Source Field
    And he types "Merlion" in the Destination Field
    And he selects the "Toll Aware" option
    When he clicks on the Get Directions button
    Then the Route Search Result should be displayed
