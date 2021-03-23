package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.players.Player;

public class FreeCard extends Card{


    @Override
    public void functionOfCard(Player player) {
        System.out.println(player.getName() + ", you have won Free Card!");
        System.out.println("When you stop at someone else's estate, you do not have to pay.");
        player.setFreeCard(true);
    }
}
