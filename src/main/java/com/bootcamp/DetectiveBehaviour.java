package com.bootcamp;

import java.util.LinkedList;
import java.util.Queue;

public class DetectiveBehaviour extends PlayerBehaviour {

    private PlayerBehaviour playerBehaviour = new CopycatBehavior();
    private Queue<Behaviour> behaviours;

    public DetectiveBehaviour() {
        initializePlayerBehaviours();
    }

    @Override
    public Behaviour play() {
        if (behaviours.size() > 0) {
            return behaviours.peek();
        } else {
            return playerBehaviour.play();
        }
    }

    @Override
    public void updateOtherPlayerBehavior(Behaviour behaviour) {
        if (behaviours.size() > 0 && Behaviour.Cheat.equals(behaviour)) {
            playerBehaviour = new CheatBehaviour();
        } else {
            playerBehaviour.updateOtherPlayerBehavior(behaviour);
        }

        behaviours.poll();
    }

    private void initializePlayerBehaviours() {
        behaviours = new LinkedList<>();
        behaviours.add(Behaviour.Cooperate);
        behaviours.add(Behaviour.Cheat);
        behaviours.add(Behaviour.Cooperate);
        behaviours.add(Behaviour.Cooperate);
    }
}
