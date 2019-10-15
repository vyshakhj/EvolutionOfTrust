package com.bootcamp;

public class ConsoleBehaviour implements PlayerBehaviour {
    private ScannerWrapper wrapper;

    public ConsoleBehaviour(ScannerWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Behaviour play() {
        if (this.wrapper.readInput().equals("CH"))
            return Behaviour.Cheat;
        else
            return Behaviour.Cooperate;
    }
}
