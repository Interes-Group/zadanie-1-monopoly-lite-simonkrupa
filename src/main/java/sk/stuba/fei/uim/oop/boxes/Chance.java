package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.players.Player;

import java.util.ArrayList;

public class Chance extends Box{

    public Chance(int position) {
        super(position);
    }

    @Override
    public void trigger(Player player) {
        System.out.println("Not ava");
    }

    public void triggerChance(Player player, ArrayList<Card> cards) {
        cards.get(0).functionOfCard(player);
        cards.remove(0);
    }
}
