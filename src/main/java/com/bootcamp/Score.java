package com.bootcamp;

public class Score {
    private int player1Score;
    private int player2Score;
    public Score(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public void updateScores(int player1Score, int player2Score) {
        this.player1Score += player1Score;
        this.player2Score += player2Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player1 score: " + this.getPlayer1Score());
        builder.append("\n");
        builder.append("Player2 score: " + this.getPlayer2Score());

        return builder.toString();
    }
}
