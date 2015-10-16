package uk.co.agilekatas.katas.rockpaperscissors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static uk.co.agilekatas.katas.rockpaperscissors.Move.*;

public final class Moves {

    private static final Map<String, List<Move>> MOVES_BY_DIFFICULTY = new HashMap<>();

    static {
        // Every time opponent played paper, they played rock afterwards, so they will again
        MOVES_BY_DIFFICULTY.put("BEGINNER_ROCK", Arrays.asList(PAPER, ROCK, PAPER));
        // Opponent played paper after rock first, then scissors then paper. Paper is most likely.
        MOVES_BY_DIFFICULTY.put("BEGINNER_PAPER", Arrays.asList(ROCK, PAPER, ROCK, SCISSORS, ROCK, PAPER, ROCK));
        // Opponent played paper after rock first, then played scissors after rock 2 times. Will play scissors again.
        MOVES_BY_DIFFICULTY.put("BEGINNER_SCISSORS", Arrays.asList(ROCK, PAPER, ROCK, SCISSORS, ROCK, SCISSORS, ROCK));
        // Opponent has never played scissors before. I don't know what they will play next.
        MOVES_BY_DIFFICULTY.put("BEGINNER_UNKNOWN", Arrays.asList(ROCK, PAPER, SCISSORS));
    }

    public static List<Move> movesFor(Difficulty difficulty, String move) {
        return MOVES_BY_DIFFICULTY.get(difficulty + "_" + move.toUpperCase());
    }

}
