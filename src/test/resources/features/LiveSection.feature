Feature: Live Section

  The Live section of MapSynq web application is responsible to provide necessary information related
  to various road conditions, viz. accidents, traffics, roadworks, road closure, obstacles etc. It also
  provides information about various cameras and tolls, installed on roads.

  @severity=normal
  Scenario: Default Incident Sub-Section
    When a user tries to open MapSynq application
    Then the Live Incidents Sub-Section should be active by default

  @severity=normal
  Scenario Outline: Sub-Sections Container Visibility
    Given a user tries to open MapSynq application
    When he clicks on the Live <subsection> Sub-Section button
    Then the Live <subsection> <container> Container should be visible
    And the Live <subsection> <container> Container should have title "<title>"

    Examples:
      | subsection | container | title                          |
      | Incidents  | Singapore | Singapore Live Traffic News    |
      | Incidents  | Malaysia  | Malaysia Live Traffic News     |
      | Incidents  | Thailand  | Thailand Live Traffic News     |
      | Incidents  | SriLanka  | SriLanka Live Traffic News     |
      | Cameras    | Singapore | Singapore Live Traffic Cameras |
      | Cameras    | Malaysia  | Malaysia Live Traffic Cameras  |
      | Cameras    | Thailand  | Thailand Live Traffic Cameras  |
      | Cameras    | SriLanka  | SriLanka Live Traffic Cameras  |
      | Tolls      | Singapore | Singapore                      |
      | Tolls      | Malaysia  | Malaysia                       |
      | Tolls      | Thailand  | Thailand                       |
      | Tolls      | SriLanka  | SriLanka                       |

  @severity=minor
  Scenario Outline: Sub-Sections Search Box Placeholder
    Given a user tries to open MapSynq application
    When he clicks on the Live <subsection> Sub-Section button
    Then the Live <subsection> <container> Search Box should have placeholder "<placeholder>"

    Examples:
      | subsection | container | placeholder              |
      | Incidents  | Singapore | Search incident location |
      #| Incidents  | Malaysia  | Search incident location |
      #| Incidents  | Thailand  | Search incident location |
      #| Incidents  | SriLanka  | Search incident location |
      | Cameras    | Singapore | Search camera location   |
      | Cameras    | Malaysia  | Search camera location   |
      #| Cameras    | Thailand  | Search camera location   |
      | Cameras    | SriLanka  | Search camera location   |
      | Tolls      | Singapore | Search toll location     |
      | Tolls      | Malaysia  | Search toll location     |
      #| Tolls      | Thailand  | Search toll location     |
      #| Tolls      | SriLanka  | Search toll location     |

  @severity=normal
  Scenario: Singapore Incidents List Dates
    Given a user tries to open MapSynq application
    When he clicks on the Live Incidents Sub-Section button
    Then the Live Incidents Singapore Date Selector List should contain today and the last 3 days

  @severity=normal
  Scenario: Singapore Incidents List Order
    Given a user tries to open MapSynq application
    When he clicks on the Live Incidents Sub-Section button
    Then the Live Incidents Singapore should be ordered in a reverse chronological order

  @severity=normal
  Scenario Outline: Switching to Other Sub-Sections
    Given a user tries to open MapSynq application
    When he clicks on the Live <subsection> Sub-Section button
    Then the Live <subsection> Sub-Section should be activated

    Examples:
      | subsection  |
      | Cameras     |
      | Tolls       |

  @severity=normal
  Scenario Outline: Sub-Sections List Content
    Given a user tries to open MapSynq application
    When he clicks on the Live <subsection> Sub-Section button
    Then the Live <subsection> <container> must contain all of the required items

    Examples:
      | subsection | container |
      | Cameras    | Singapore |
      | Cameras    | Malaysia  |
      #| Cameras    | Thailand  |
      | Cameras    | SriLanka  |
      | Tolls      | Singapore |
      | Tolls      | Malaysia  |
      #| Tolls      | Thailand  |
      #| Tolls      | SriLanka  |

  @severity=critical
  Scenario Outline: Sub-Sections Item Search
    Given a user tries to open MapSynq application
    And he clicks on the Live <subsection> Sub-Section button
    When he types "<search>" in the Live <subsection> <container> Search Box
    Then the Live <subsection> <container> search result will contain "<search>"

    Examples:
      | subsection | container | search                             |
      | Cameras    | Singapore | Woodlands Causeway (Towards Johor) |
      | Cameras    | Malaysia  | Persiaran Titiwangsa               |
      #| Cameras    | Thailand  |                                    |
      | Cameras    | SriLanka  | Kiribathgoda Junction              |
      | Tolls      | Singapore | CTE Northbound after PIE           |
      | Tolls      | Malaysia  | Kapar (E) to Bukit Raja            |
      #| Tolls      | Thailand  |                                    |
      #| Tolls      | SriLanka  |                                    |