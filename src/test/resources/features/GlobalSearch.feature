Feature: MapSynq Global Search

  The MapSynq Global Search is responsible to provide a glbal search functionality over the MapSynq application.
  This feature is responsible to test the visibility of the MapSynq Search Result upon a user initiated Global
  Search.

  @severity=critical
  Scenario: MapSynq Global Search
    Given a user tries to open MapSynq application
    And he types the string "Woodlands Causeway (Towards Johor)" in the Global Search Field
    When he clicks on the MapSynq Global Search Button
    Then the MapSynq Global Search result should be displayed