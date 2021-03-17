package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public abstract class Box {
    protected int position;

    public Box(int position) {
        this.position = position;
    }

    public abstract void trigger();

}
