package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Prison extends Box{

    public Prison(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println(player.getName() + " visited prison.");
    }

}
