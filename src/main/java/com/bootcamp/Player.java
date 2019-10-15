package com.bootcamp;

public class Player {
    private PlayerBehaviour behaviour;

    public Player(PlayerBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public Behaviour play() {
       return this.behaviour.play();
    }
}
