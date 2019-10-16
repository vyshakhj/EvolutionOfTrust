package com.bootcamp;

public class CopycatBehavior extends PlayerBehaviour {
    private boolean isFirstPlay = true;
    private Behaviour opponentsBehaviour;

    public void saveOpponentsBehaviour(Behaviour behaviour){
        this.opponentsBehaviour = behaviour;
    }

    @Override
    public Behaviour play() {
        if (isFirstPlay) {
            isFirstPlay = false;
            return Behaviour.Cooperate;
        } else {
            return this.opponentsBehaviour;
        }
    }
}
