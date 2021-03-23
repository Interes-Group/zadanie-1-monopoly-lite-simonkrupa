package sk.stuba.fei.uim.oop.boxes;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.DiscountCard;
import sk.stuba.fei.uim.oop.players.Player;

import java.util.ArrayList;

public class Chance extends Box{
    private ArrayList<Card> cards;

    public Chance(int position) {
        super(position);
        this.cards = new ArrayList<>();
        cards.add(new DiscountCard());
    }

    @Override
    public void trigger(Player player) {
        System.out.println("cc");
    }

    public void triggerChance(Player player, ArrayList<Card> cards) {
        cards.get(0).functionOfCard(player);
        cards.remove(0);
    }
}
