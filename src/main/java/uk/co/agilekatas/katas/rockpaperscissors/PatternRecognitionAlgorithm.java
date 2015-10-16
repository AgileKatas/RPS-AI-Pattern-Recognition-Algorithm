package uk.co.agilekatas.katas.rockpaperscissors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternRecognitionAlgorithm {

    private Difficulty difficulty;
    private List<Move> history;

    public PatternRecognitionAlgorithm(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.history = new ArrayList<>();
    }

    public void addHistory(Move move) {
        history.add(move);
    }

    public Move nextMove() {
        List<Move> playedNext = new ArrayList<>();
        if (history.isEmpty())
            return Move.ROCK;
        Move lastPlayed = history.get(history.size() - 1);
        for (int i = 0; i < history.size() - 1; i++) {
            Move move = history.get(i);
            if (move.equals(lastPlayed)) {
                playedNext.add(history.get(i + 1));
            }
        }
        return moveThatBeats(mostCommon(playedNext));
    }

    private Move mostCommon(List<Move> moves) {
        Map<Move, Integer> frequency = new HashMap<>();
        for(Move move : moves) {
            Integer current = frequency.get(move);
            frequency.put(move, current == null ? 1 : current + 1);
        }

        Map.Entry<Move, Integer> mostCommon = null;

        for (Map.Entry<Move, Integer> entry : frequency.entrySet()) {
            if(mostCommon == null || entry.getValue() > mostCommon.getValue())
                mostCommon = entry;
        }

        return mostCommon == null ? Move.SCISSORS : mostCommon.getKey();
    }

    private Move moveThatBeats(Move move) {
        switch (move) {
            case ROCK:
                return Move.PAPER;
            case PAPER:
                return Move.SCISSORS;
            case SCISSORS:
                return Move.ROCK;
            default:
                return Move.ROCK;
        }
    }
}
