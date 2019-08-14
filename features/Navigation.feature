Feature: Navigation between Pages

  In MapSynq web application, there are a total of 11 pages among which a concrete navigation flow exists.
  This feature is responsible to validate the navigational requirements between those pages.

  Scenario: Map Page Navigation

    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told Yes