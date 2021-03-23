package sk.stuba.fei.uim.oop.cards;

import sk.stuba.fei.uim.oop.players.Player;

public class DiscountCard extends Card{
    public DiscountCard(int position) {
        super(position);
    }

    @Override
    public void functionOfCard(Player player) {
        System.out.println("You won Discount Card, you can use it on any estate you will stand on and you will receive 100% discount");
        player.setDiscountCard(true);
    }
}
