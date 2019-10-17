package com.bootcamp;

import java.util.LinkedList;
import java.util.Queue;

public class DetectiveBehaviour extends PlayerBehaviour {

    private PlayerBehaviour playerBehaviour = new CopycatBehavior();
    private Queue<Move> moves;

    public DetectiveBehaviour() {
        initializePlayerBehaviours();
    }

    @Override
    public Move play() {
        if (hasMoreDefaultMoves()) {
            return moves.peek();
        } else {
            return playerBehaviour.play();
        }
    }

    @Override
    public void saveOpponentsMove(Move move) {
        if (hasMoreDefaultMoves() && Move.Cheat.equals(move)) {
            playerBehaviour = new CheatBehaviour();
        } else {
            playerBehaviour.saveOpponentsMove(move);
        }

        moves.poll();
    }

    private void initializePlayerBehaviours() {
        moves = new LinkedList<>();
        moves.add(Move.Cooperate);
        moves.add(Move.Cheat);
        moves.add(Move.Cooperate);
        moves.add(Move.Cooperate);
    }

    private boolean hasMoreDefaultMoves() {
        return this.moves.size() > 0;
    }
}
