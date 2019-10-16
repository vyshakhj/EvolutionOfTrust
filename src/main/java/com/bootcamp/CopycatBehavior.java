package com.bootcamp;

public class CopycatBehavior extends PlayerBehaviour {
    private boolean isFirstPlay = true;
    private Behaviour otherPlayerBehavior;

    public void updateOtherPlayerBehavior(Behaviour behaviour){
        this.otherPlayerBehavior = behaviour;
    }

    @Override
    public Behaviour play() {
        if (isFirstPlay) {
            isFirstPlay = false;
            return Behaviour.Cooperate;
        } else {
            return this.otherPlayerBehavior;
        }
    }
}
