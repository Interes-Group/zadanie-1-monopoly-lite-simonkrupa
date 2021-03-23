package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.players.Player;

public class PenaltyCard extends Card{
    private final int penaltyAmount = 5000;


    @Override
    public void functionOfCard(Player player) {
        System.out.println(player.getName() + ", sadly, you have exceeded the speed limit on your car.");
        System.out.println("You must pay " + penaltyAmount);
        player.setCash(-penaltyAmount);
    }
}
