package com.bootcamp;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Player(new ConsoleBehaviour(new ScannerWrapper())), new Player(new CheatBehaviour()),1);
        Score score = game.start();
        System.out.println(score);
    }
}
