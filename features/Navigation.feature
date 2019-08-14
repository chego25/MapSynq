Feature: Navigation between Pages

  In MapSynq web application, there are a total of 11 pages among which a concrete navigation flow exists.
  This feature is responsible to validate the navigational requirements between those pages.

  Scenario: Map Page Navigation

    Given a user is in the Map Page of MapSynq application
    When he clicks on the Login Page link in the Map Page
    Then he should be displayed the Login Page of MapSync