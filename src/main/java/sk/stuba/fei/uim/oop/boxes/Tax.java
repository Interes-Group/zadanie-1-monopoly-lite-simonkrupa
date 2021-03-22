package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Tax extends Box{
    private final int taxAmount = -500;

    public Tax(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println("You must pay taxes!");
        System.out.println("You paid 500 cash");
        player.setCash(this.taxAmount);
    }
}
