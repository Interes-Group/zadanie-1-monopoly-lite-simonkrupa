package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Start extends Box {
    private final int startBonus = 1000;

    public Start(int position) {
        super(position);
    }

    public int getStartBonus() {
        return startBonus;
    }

    @Override
    public void trigger(Player player) {
        System.out.println(player.getName() + " you are standing on Start, you have received extra 1000 cash");
        player.setCash(1000);
    }
}
