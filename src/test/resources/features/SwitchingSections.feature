Feature: Switching Sections

  By default, if a user navigates to http://www.mapsynq.com, the Live section becomes active automatically.
  This feature is responsible to validate the default active section.

  @severity=normal
  Scenario: Default Section

    Given a user tries to open MapSynq application
    Then the Live Section should be active by default

  Scenario Outline: Switching Sections
    Given a user tries to open MapSynq application
    When he clicks on the <section> Section button
    Then the <section> Section should be activated

    Examples:
      | section    |
      | Directions |
      | Personal   |