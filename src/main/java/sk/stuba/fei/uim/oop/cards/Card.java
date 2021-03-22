package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.Player;

public abstract class Card {
    protected int position;

    public Card(int position){
        this.position = position;
    }

    public abstract void functionOfCard(Player player);
}
