package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Police extends Box{

    public Police(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println("we ll send u to prison");
    }
}
