package com.bootcamp;

public class CheatBehaviour implements PlayerBehaviour {
    @Override
    public Behaviour play() {
        return Behaviour.Cheat;
    }
}
