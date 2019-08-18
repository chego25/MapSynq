Feature: Pages Navigation

  In MapSynq web application, there are a total of 9 pages among which a concrete navigation flow exists.
  This feature is responsible to validate the navigational requirements between those pages.

  @severity=normal
  Scenario Outline: Pages Navigation

    Given a user is in the <source> Page of MapSynq application
    When he clicks on the <destination> Page link in the <source> Page
    Then the <destination> Page should have the title "<title>"

    Examples:
      | source   | destination | title                                                                 |
      | Map      | Login       | mapSYNQ user profile                                                  |
      | Map      | Register    | mapSYNQ user profile                                                  |
      | Map      | App         | mapSYNQ Mobile                                                        |
      | Map      | Galactio    | Galactio                                                              |
      | Map      | Store       | Galactio - Navigation & Maps for Urban Mobility - Apps on Google Play |
      | Map      | About       | about mapSYNQ                                                         |
      | Map      | TnC         | mapSYNQ terms and conditions                                          |
      | Login    | Map         | mapSYNQ - Live Traffic Information Platform                           |
      | Login    | App1        | mapSYNQ Mobile                                                        |
      | Login    | Store       | Galactio - Navigation & Maps for Urban Mobility - Apps on Google Play |
      | Login    | Register    | mapSYNQ user profile                                                  |
      | Login    | App2        | mapSYNQ Mobile                                                        |
      | Login    | Password    | mapSYNQ user profile                                                  |
      | Register | Map         | mapSYNQ - Live Traffic Information Platform                           |
      | Register | App         | mapSYNQ Mobile                                                        |
      | Register | Store       | Galactio - Navigation & Maps for Urban Mobility - Apps on Google Play |
      | App      | Map         | mapSYNQ - Live Traffic Information Platform                           |
      | App      | Store       | Galactio - Navigation & Maps for Urban Mobility - Apps on Google Play |