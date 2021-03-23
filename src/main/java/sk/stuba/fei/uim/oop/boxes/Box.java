package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.players.Player;


public abstract class Box {
    protected int position;

    public Box(int position) {
        this.position = position;
    }

    public abstract void trigger(Player player);

}
