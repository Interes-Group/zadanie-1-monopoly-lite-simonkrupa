package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.Player;

public class Police extends Box{

    public Police(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println(player.getName() +  ", you stepped on Police. We are taking you to prison! You will have to wait one round.");
        player.setPrisonPosition();
        player.setMove(false);
    }
}
