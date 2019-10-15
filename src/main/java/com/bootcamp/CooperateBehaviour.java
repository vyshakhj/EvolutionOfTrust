package com.bootcamp;

public class CooperateBehaviour implements PlayerBehaviour {
    @Override
    public Behaviour play() {
        return Behaviour.Cooperate;
    }
}
