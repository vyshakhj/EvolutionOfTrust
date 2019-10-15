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
        for (int i = 0; i < this.numberOfRounds; i++) {
            Behaviour playerOneInput = player1.play();
            Behaviour playerTwoInput = player2.play();
            Score roundScore = rule(playerOneInput, playerTwoInput);
            this.score.updateScores(roundScore.getPlayer1Score(), roundScore.getPlayer2Score());
        }

        return this.score;
    }

    public Score rule(Behaviour player1Input, Behaviour player2Input) {
        if (player1Input.equals(Behaviour.Cooperate) && player2Input.equals(Behaviour.Cooperate)) {
            return  new Score(2, 2);
        }
        if (player1Input.equals(Behaviour.Cooperate) && player2Input.equals(Behaviour.Cheat)) {
            return  new Score(-1, 3);
        }
        if (player1Input.equals(Behaviour.Cheat) && player2Input.equals(Behaviour.Cooperate)) {
            return  new Score(3, -1);
        }
        if (player1Input.equals(Behaviour.Cheat) && player2Input.equals(Behaviour.Cheat)) {
            return  new Score(0, 0);
        }

        return null;
    }
}
