Feature: Map Page Dialogs

  Feedback and FAQ modules comes inside two modals which can be opened from the Map Page.
  This feature is responsible to test the appearance of those modals and internal contents.

  @severity=normal
  Scenario Outline: Map Page Dialogs

    Given a user is in the Map Page of MapSynq application
    When he clicks on the <dialog> Dialog link in the Map Page
    Then the <dialog> Dialog should be appearing in the UI

    Examples:
      | dialog   |
      | Feedback |
      | FAQ      |
      | Legend   |
      | Calendar |