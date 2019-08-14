Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Monday
    Given today is Monday
    When I ask whether it's Tuesday yet
    Then I should be told No