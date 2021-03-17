package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.boxes.Box;

public class Start extends Box {
    private final int startBonus = 1000;

    public Start(int position) {
        super(position);
    }

    public int getStartBonus() {
        return startBonus;
    }
}
