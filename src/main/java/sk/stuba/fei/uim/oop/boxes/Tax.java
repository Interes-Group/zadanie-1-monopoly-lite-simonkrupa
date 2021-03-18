package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Tax extends Box{
    public Tax(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println("You must pay taxes!");
    }
}
