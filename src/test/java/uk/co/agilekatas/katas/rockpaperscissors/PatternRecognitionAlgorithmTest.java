package uk.co.agilekatas.katas.rockpaperscissors;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternRecognitionAlgorithmTest {

    private PatternRecognitionAlgorithm algorithm = new PatternRecognitionAlgorithm(Difficulty.BEGINNER);

    @Test
    public void shouldReturnRockWhenHistoryIsEmpty() {
        Move move = algorithm.nextMove();
        assertThat(move).isEqualTo(Move.ROCK);
    }

    @Test
    public void shouldReturnRockWhenNextMoveIsUnknown() {
        algorithm.addHistory(Move.PAPER);
        Move move = algorithm.nextMove();
        assertThat(move).isEqualTo(Move.ROCK);
    }

    @Test
    public void shouldReturnScissorsWhenOpponentPlaysMoveThatWasPreviouslyPlayedBeforePaper() {
        algorithm.addHistory(Move.SCISSORS);
        algorithm.addHistory(Move.PAPER);
        algorithm.addHistory(Move.SCISSORS);

        Move move = algorithm.nextMove();

        assertThat(move).isEqualTo(Move.SCISSORS);
    }

    @Test
    public void shouldReturnPaperWhenOpponentPlaysMoveThatWasPreviouslyPlayedBeforeRockTheMost() {
        algorithm.addHistory(Move.SCISSORS);
        algorithm.addHistory(Move.PAPER);
        algorithm.addHistory(Move.SCISSORS);
        algorithm.addHistory(Move.ROCK);
        algorithm.addHistory(Move.SCISSORS);
        algorithm.addHistory(Move.ROCK);
        algorithm.addHistory(Move.SCISSORS);

        Move move = algorithm.nextMove();

        assertThat(move).isEqualTo(Move.PAPER);
    }
    
}
