Feature: MapSynq First Load

  By default, if a user navigates to http://www.mapsynq.com, the Map Page with live traffic status opens.
  This feature is responsible to validate the loading of the Map Page for the first time.

  Scenario: MapSynq First Load

    Given a user tries to open MapSynq application
    Then the Map Page should be loaded by default