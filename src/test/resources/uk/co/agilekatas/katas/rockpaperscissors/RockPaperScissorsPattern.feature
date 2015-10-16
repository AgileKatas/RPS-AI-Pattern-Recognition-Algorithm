Feature: Rock Paper Scissors AI | Pattern Recognition Algorithm

  Scenario Outline: Beginner Algorithm returns move that should beat opponent
    Given I am using a 'beginner' pattern recognition algorithm
    And it looks like the opponent will play <Move>
    When I calculate my next move
    Then the calculated move should be <Winning Move>

    Examples:
      | Move     | Winning Move |
      | Rock     | Paper        |
      | Scissors | Rock         |
      | Paper    | Scissors     |
      | Unknown  | Rock         |
