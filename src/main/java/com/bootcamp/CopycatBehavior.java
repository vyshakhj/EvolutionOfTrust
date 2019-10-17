package com.bootcamp;

public class CopycatBehavior extends PlayerBehaviour {
    private boolean isFirstPlay = true;
    private Move opponentsMove;

    public void saveOpponentsMove(Move move){
        this.opponentsMove = move;
    }

    @Override
    public Move play() {
        if (isFirstPlay) {
            isFirstPlay = false;
            return Move.Cooperate;
        } else {
            return this.opponentsMove;
        }
    }
}
