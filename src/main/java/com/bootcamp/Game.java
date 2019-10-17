package com.bootcamp;

public class Game {

    private Score score = new Score(0, 0);
    private Player player1;
    private Player player2;
    private int numberOfRounds;

    public Game(Player player1, Player player2, int numberOfRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.numberOfRounds = numberOfRounds;
    }

    public Score start() {
        for (int round = 1; round <= this.numberOfRounds; round++) {
            Move playerOneInput = player1.play();
            Move playerTwoInput = player2.play();
            Score roundScore = rule(playerOneInput, playerTwoInput);
            if (roundScore != null) {
                this.score.updateScores(roundScore.getPlayer1Score(), roundScore.getPlayer2Score());
            }

            player1.updatePreviousMove(playerTwoInput);
            player2.updatePreviousMove(playerOneInput);
        }

        return this.score;
    }

    private Score rule(Move player1Input, Move player2Input) {
        if (player1Input.equals(Move.Cooperate) && player2Input.equals(Move.Cooperate)) {
            return  new Score(2, 2);
        }
        if (player1Input.equals(Move.Cooperate) && player2Input.equals(Move.Cheat)) {
            return  new Score(-1, 3);
        }
        if (player1Input.equals(Move.Cheat) && player2Input.equals(Move.Cooperate)) {
            return  new Score(3, -1);
        }
        if (player1Input.equals(Move.Cheat) && player2Input.equals(Move.Cheat)) {
            return  new Score(0, 0);
        }

        return null;
    }
}
