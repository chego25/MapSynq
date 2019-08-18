Feature: Live Section

  The Live section of MapSynq web application is responsible to provide necessary information related
  to various road conditions, viz. accidents, traffics, roadworks, road closure, obstacles etc. It also
  provides information about various cameras and tolls, installed on roads.

  Scenario: Default Incident Sub-Section
    When a user tries to open MapSynq application
    Then the Live Incidents Sub-Section should be active by default
    And the Live Incidents Singapore Container should be visible
    And the Live Incidents Singapore Container should have title "Singapore Live Traffic News"
    And the Live Incidents Singapore Search Box should have placeholder "Search incident location"
    And the Live Incidents Singapore Date Selector List should contain today and the last 3 days
    And the Live Incidents Singapore should be ordered in a reverse chronological order
    And the Live Incidents Malaysia Container should be visible
    And the Live Incidents Thailand Container should be visible
    And the Live Incidents SriLanka Container should be visible


  Scenario: Switching to Cameras Sub-Section
    Given a user tries to open MapSynq application
    When he clicks on the Live Cameras Sub-Section button
    Then the Live Cameras Sub-Section should be activated
    And the Live Cameras Singapore Container should be visible
    And the Live Cameras Singapore Container should have title "Singapore Live Traffic Cameras"
    And the Live Cameras Singapore Search Box should have placeholder "Search camera location"
    And the Live Cameras Malaysia Container should be visible
    And the Live Cameras Malaysia Container should have title "Malaysia Live Traffic Cameras"
    And the Live Cameras Malaysia Search Box should have placeholder "Search camera location"
    And the Live Cameras SriLanka Container should be visible
    And the Live Cameras SriLanka Container should have title "SriLanka Live Traffic Cameras"
    And the Live Cameras SriLanka Search Box should have placeholder "Search camera location"
    And the Live Cameras Thailand Container should be visible

  Scenario: Switching to Tolls Sub-Section
    Given a user tries to open MapSynq application
    When he clicks on the Live Tolls Sub-Section button
    Then the Live Tolls Sub-Section should be activated
    And the Live Tolls Singapore Container should be visible
    And the Live Tolls Singapore Container should have title "Singapore"
    And the Live Tolls Singapore Search Box should have placeholder "Search toll location"
    And the Live Tolls Malaysia Container should be visible
    And the Live Tolls Malaysia Container should have title "Malaysia"
    And the Live Tolls Malaysia Search Box should have placeholder "Search toll location"
    And the Live Tolls Thailand Container should be visible
    And the Live Tolls SriLanka Container should be visible