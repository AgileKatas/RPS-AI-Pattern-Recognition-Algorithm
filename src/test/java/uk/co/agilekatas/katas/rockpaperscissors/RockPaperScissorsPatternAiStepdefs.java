package uk.co.agilekatas.katas.rockpaperscissors;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsPatternAiStepdefs {

    private Difficulty difficulty;

    private PatternRecognitionAlgorithm algorithm;
    private Move nextMove;

    @Given("^I am using a '(.*)' pattern recognition algorithm$")
    public void I_am_using_a_beginner_pattern_recognition_algorithm(String difficulty) {
        this.difficulty = Difficulty.valueOf(difficulty.toUpperCase());
        algorithm = new PatternRecognitionAlgorithm(this.difficulty);
    }

    @And("^it looks like the opponent will play (.*)$")
    public void it_looks_like_the_opponent_will_play_Move(String move) {
        for (Move opponentMove : Moves.movesFor(difficulty, move))
            algorithm.addHistory(opponentMove);
    }

    @When("^I calculate my next move$")
    public void I_calculate_my_next_move() throws Throwable {
        nextMove = algorithm.nextMove();
    }

    @Then("^the calculated move should be (.*)$")
    public void the_calculated_move_should_be_Winning_Move(String winningMove) throws Throwable {
        assertThat(nextMove).isEqualTo(Move.valueOf(winningMove.toUpperCase()));
    }

}
