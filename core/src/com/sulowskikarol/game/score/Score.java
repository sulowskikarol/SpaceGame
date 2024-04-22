package com.sulowskikarol.game.score;

public class Score implements ScoreObserver {
    private static int totalScore = 0;

    @Override
    public void updateScore(int points) {
        totalScore += points;
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public void resetTotalScore() {
        totalScore = 0;
    }
}
