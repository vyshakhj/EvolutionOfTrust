package com.bootcamp;

public class Player {
    private PlayerBehaviour behaviour;

    public Player(PlayerBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public Move play() {
       return this.behaviour.play();
    }

    public void updatePreviousMove(Move behavior) {
        this.behaviour.saveOpponentsMove(behavior);
    }
}
