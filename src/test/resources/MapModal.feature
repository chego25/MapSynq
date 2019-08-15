Feature: Map Page Modals

  Feedback and FAQ modules comes inside two modals which can be opened from the Map Page.
  This feature is responsible to test the appearance of those modals and internal contents.

  Scenario Outline: Map Page Modals

    Given a user is in the Map Page of MapSynq application
    When he clicks on the <modal> Modal link in the Map Page
    Then the <modal> Modal should be appearing in the UI

    Examples:
      | modal    |
      | Feedback |
      | FAQ      |