package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.players.Player;

public class JackpotCard extends Card{
    private final int jackpotAmount = 10000;

    @Override
    public void functionOfCard(Player player) {
        System.out.println(player.getName() + ", you have won Jackpot!");
        System.out.println("You will get " + jackpotAmount + ", congrats!");
        player.setCash(jackpotAmount);
    }
}
