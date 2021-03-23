package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.players.Player;

public class VacationCard extends Card {
    private final int vacationLength = 1;

    @Override
    public void functionOfCard(Player player) {
        System.out.println(player.getName() + ", you went on a vacation.");
        System.out.println("You will rest " + vacationLength + " round on vacation, enjoy.");
        player.setMove(false);
    }
}
