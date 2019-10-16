package com.bootcamp;

public abstract class PlayerBehaviour {
    public abstract Behaviour play();
    public void updateOtherPlayerBehavior(Behaviour behaviour) {
    };
}
