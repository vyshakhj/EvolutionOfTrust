package com.bootcamp;

public class ConsoleBehaviour extends PlayerBehaviour {
    private ScannerWrapper wrapper;

    public ConsoleBehaviour(ScannerWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Move play() {
        if (this.wrapper.readInput().equals("CH"))
            return Move.Cheat;
        else
            return Move.Cooperate;
    }
}
