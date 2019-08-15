Feature: Navigation between Pages

  In MapSynq web application, there are a total of 11 pages among which a concrete navigation flow exists.
  This feature is responsible to validate the navigational requirements between those pages.

  Scenario Outline: Map Page Navigation

    Given a user is in the <source> Page of MapSynq application
    When he clicks on the <destination> Page link in the <source> Page
    Then he should be displayed the <destination> Page of MapSynq

    Examples:
      | source | destination |
      | Map    | Login       |
      | Map    | Register    |
      | Map    | App         |
      | Map    | Galactio    |
      | Map    | Store       |